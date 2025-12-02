package com.arnav.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Farmer {

    @Id
    @Column(name = "farmer_id")
    private int farmerId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "farmer_id")
    private Users user;

    @NotNull
    @Column(length = 40,name = "farm_location")
    private String farmLocation;

    @NotNull
    @Column(length = 20,name = "land_area")
    private String landArea;

    @OneToMany(mappedBy = "farmer")
    private List<Farmers_Listings> listings;

}