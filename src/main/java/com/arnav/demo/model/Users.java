package com.arnav.demo.model;

import jakarta.persistence.*;
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
    private int user_id;

    @Column(length = 50)
    @NotNull
    private String full_name;

    @Column(length = 30,unique = true)
    @NotNull(message="Email must not be empty")
    private String email;

    @Column(length = 10,unique = true)
    @NotNull
    private String phone_no;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRoles userRoles;

    @Column(length = 255)
    @NotNull
    private String password_hash;

    @NotNull
    private Date createdAt;

    @OneToMany(mappedBy = "users")
    private List<Feedback> feedbacks;

    @OneToOne(mappedBy = "user")
    private Permanent_Shipping_Address psa;

    @OneToOne(mappedBy = "user")
    private Alternate_Shipping_Address asa;

    @OneToMany(mappedBy = "farmer")
    private List<Farmers_Listings> listings;

    @OneToOne(mappedBy = "user")
    private Farmer farmer;

    @OneToOne(mappedBy = "user")
    private Restaurant restaurant;

    @OneToOne(mappedBy = "user")
    private Ngo ngo;

    @OneToOne(mappedBy = "user")
    private Government government;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    private List<Order> orders;

    @OneToMany(mappedBy = "payer", fetch = FetchType.LAZY)
    private List<Payment> paymentsMade;

    @OneToMany(mappedBy = "payee", fetch = FetchType.LAZY)
    private List<Payment> paymentsReceived;

}
