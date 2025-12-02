package com.arnav.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(length = 50,name = "full_name")
    @NotNull
    private String fullName;

    @Column(length = 30,unique = true)
    @NotNull(message="Email must not be empty")
    @Email
    private String email;

    @Column(length = 10,unique = true,name = "phone_no")
    @NotNull
    private String phoneNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private UserRoles userRoles;

    @Column(length = 255)
    @NotNull
    private String password_hash;

    @NotNull
    private Date createdAt;

    @OneToMany(mappedBy = "user")
    private List<Feedback> feedbacks;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Permanent_Shipping_Address psa;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Alternate_Shipping_Address asa;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Farmer farmer;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Restaurant restaurant;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Ngo ngo;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Government government;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    private List<Order> orders;

    @OneToMany(mappedBy = "payer", fetch = FetchType.LAZY)
    private List<Payment> paymentsMade;

    @OneToMany(mappedBy = "payee", fetch = FetchType.LAZY)
    private List<Payment> paymentsReceived;

}
