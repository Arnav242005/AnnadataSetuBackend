package com.arnav.demo.model;

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
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private Users payer;

    @ManyToOne
    @JoinColumn(name = "payee_id")
    private Users payee;

    @NotNull
    @Column(name = "payment_mode")
    private String paymentMode;

    @NotNull
    @Column(name = "payment_status")
    private String paymentStatus;

    @NotNull
    private double amount;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP",name = "payment_date")
    private Date paymentDate;

    @Column(unique = true, length = 50,name = "transaction_id")
    private String transactionId;
}
