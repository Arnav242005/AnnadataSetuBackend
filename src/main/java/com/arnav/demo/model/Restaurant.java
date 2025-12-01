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
    private int restaurant_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "restaurant_id")
    private Users user;

    @NotNull
    @Column(unique = true,length = 30)
    private String restaurant_name;

    @NotNull
    @Column(unique = true,length = 20)
    private String license_no;
}
