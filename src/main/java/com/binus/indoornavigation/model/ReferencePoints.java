package com.binus.indoornavigation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "referencepoints")
public class ReferencePoints {

    @Id
    @Column(name = "referencepointid")
    private Integer id;

    @Column(name = "mapid")
    private BigInteger mapId;

}
