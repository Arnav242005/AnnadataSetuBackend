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
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "listing_id")
    private Farmers_Listings listing;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Users buyer;

    @NotNull
    private double quantity;

    @NotNull
    @Column(name = "total_price")
    private double totalPrice;

    @NotNull
    @Column(name = "order_status")
    private String orderStatus;  // Pending, Confirmed, Delivered, Cancelled

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP",name = "order_date")
    private Date orderDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
    private Payment payments;

}
