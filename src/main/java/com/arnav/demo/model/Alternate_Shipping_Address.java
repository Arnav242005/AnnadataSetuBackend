package com.arnav.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alternate_Shipping_Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(length = 90)
    @NotNull
    private String address;

    @Column(length = 20)
    @NotNull
    private String city;

    @Column(length = 20)
    @NotNull
    private String state;

    @Column(length = 6)
    @NotNull
    private String pincode;

    @Column(length = 30)
    @NotNull
    private String landmark;
}
