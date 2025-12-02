package com.arnav.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    @ManyToOne
    @JoinColumn(name = "listing_id")
    private Farmers_Listings listing;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Users buyer;

    @NotNull
    private double quantity;

    @NotNull
    private double total_price;

    @NotNull
    private String order_status;  // Pending, Confirmed, Delivered, Cancelled

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date order_date;

    private Date delivery_date;

    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
    private Payment payments;

}
