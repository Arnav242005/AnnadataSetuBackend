package com.arnav.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmers_Listings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listing_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "farmer_id")
    private Users user;
}
