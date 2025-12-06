package com.arnav.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties({
        "hibernateLazyInitializer",
        "handler",
        "decoratedClass"
})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(length = 50, name = "full_name")
    @NotNull
    private String fullName;

    @Column(length = 30, unique = true)
    @NotNull(message="Email must not be empty")
    @Email
    private String email;

    @Column(length = 10, unique = true, name = "phone_no")
    @NotNull
    private String phoneNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @ToString.Exclude
    private UserRoles userRoles;

    @Column(length = 255)
    @NotNull
    private String password_hash;

    @NotNull
    private Date createdAt;

    // ----- RELATIONS (marked JsonIgnore to avoid recursion) -----

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @ToString.Exclude
    private List<Feedback> feedbacks;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Permanent_Shipping_Address psa;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Alternate_Shipping_Address asa;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Farmer farmer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Restaurant restaurant;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Ngo ngo;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Government government;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private List<Order> orders;

    @OneToMany(mappedBy = "payer", fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private List<Payment> paymentsMade;

    @OneToMany(mappedBy = "payee", fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private List<Payment> paymentsReceived;
}
