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
public class Government {

    @Id
    private int govt_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "govt_id")
    private Users user;

    @NotNull
    @Column(length = 20)
    private String department_name;

    @NotNull
    @Column(length = 30)
    private String designation;
}
