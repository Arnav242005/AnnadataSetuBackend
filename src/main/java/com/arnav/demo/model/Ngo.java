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
    @Column(name = "ngo_id")
    private int ngoId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ngo_id")
    private Users user;

    @Column(length = 30,name = "ngo_name")
    private String ngoName;

    @Column(length = 20,unique = true,name = "registration_no")
    @NotNull
    private String registrationNo;

    @Column(length = 30,name = "focus_area")
    @NotNull
    private String focusArea;
}
