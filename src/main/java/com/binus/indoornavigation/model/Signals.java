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
@Table(name = "signals")
public class Signals {

    @Id
    @Column(name = "signalid")
    private String id;

    @Column(name = "rssi")
    private double RSSI;

    @Column(name = "beaconid")
    private String beaconId;

    @Column(name = "referencepointid")
    private int referencePointId;

}
