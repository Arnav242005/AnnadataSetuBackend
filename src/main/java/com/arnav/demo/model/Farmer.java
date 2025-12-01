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
    private int farmer_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "farmer_id")
    private Users user;

    @NotNull
    @Column(length = 40)
    private String farm_location;

    @NotNull
    @Column(length = 20)
    private String land_area;
}