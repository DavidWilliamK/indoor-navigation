package com.binus.indoornavigation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "maps")
public class Maps {

    @Id
    @Column(name = "mapid")
    private int id;

    @Column(name = "mapname")
    private String name;

}
