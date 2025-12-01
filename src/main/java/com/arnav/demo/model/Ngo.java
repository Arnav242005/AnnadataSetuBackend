package com.arnav.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ngo {

    @Id
    private int ngo_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ngo_id")
    private Users user;

    @Column(length = 30)
    private String ngo_name;

    @Column(length = 20,unique = true)
    @NotNull
    private String registration_no;

    @Column(length = 30)
    @NotNull
    private String focus_area;
}
