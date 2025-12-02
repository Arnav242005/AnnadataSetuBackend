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
    @Column(name = "listing_id")
    private int listingId;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    @NotNull
    @Column(length = 30,name = "type_of_crop")
    private String typeOfCrop;

    @NotNull
    @Column(name = "quantity_available")
    private double quantityAvailable;

    @NotNull
    @Column(name = "unit_price")
    private double unitPrice;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP",name = "post_date")
    private Date postDate;

    @NotNull
    private String status;
}
