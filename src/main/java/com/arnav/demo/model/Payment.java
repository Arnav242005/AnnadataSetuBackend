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
    private int payment_id;

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
    private String payment_mode;

    @NotNull
    private String payment_status;

    @NotNull
    private double amount;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date payment_date;

    @Column(unique = true, length = 50)
    private String transaction_id;
}
