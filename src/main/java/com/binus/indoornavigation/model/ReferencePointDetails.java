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
@Table(name = "referencepointdetails")
public class ReferencePointDetails {

    @Id
    @Column(name = "referencepointdetailid")
    private int id;

    @Column(name = "referencepointid")
    private int pointId;

    @Column(name = "coordinatex")
    private int coor_x;

    @Column(name = "coordinatey")
    private int coor_y;

}
