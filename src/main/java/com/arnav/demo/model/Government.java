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
    @Column(name = "govt_id")
    private int govtId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "govt_id")
    private Users user;

    @NotNull
    @Column(length = 20,name = "department_name")
    private String departmentName;

    @NotNull
    @Column(length = 30)
    private String designation;
}
