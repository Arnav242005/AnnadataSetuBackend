package com.arnav.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @Column(name = "restaurant_id")
    private int restaurantId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "restaurant_id")
    private Users user;

    @NotNull
    @Column(unique = true,length = 30,name = "restaurant_name")
    private String restaurantName;

    @NotNull
    @Column(unique = true,length = 20,name = "license_no")
    private String licenseNo;
}
