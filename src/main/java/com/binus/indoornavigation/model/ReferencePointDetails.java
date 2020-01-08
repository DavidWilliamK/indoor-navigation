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
    private Integer id;

    @Column(name = "referencepointid")
    private Integer pointId;

    @Column(name = "coordinatex")
    private Integer coor_x;

    @Column(name = "coordinatey")
    private Integer coor_y;

}
