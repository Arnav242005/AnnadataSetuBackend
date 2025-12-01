package com.arnav.demo.model;

import com.arnav.demo.model.Farmer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Farmers_Listings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listing_id;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    @NotNull
    @Column(length = 30)
    private String type_of_crop;

    @NotNull
    private double quantity_available;

    @NotNull
    private double unit_price;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date post_date;

    @NotNull
    private String status;
}
