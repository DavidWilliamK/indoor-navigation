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
public class Signals implements Comparable{

    @Id
    @Column(name = "signalid")
    private String id;

    @Column(name = "rssi")
    private Double RSSI;

    @Column(name = "beaconid")
    private String beaconId;

    @Column(name = "referencepointid")
    private Integer referencePointId;

    @Override
    public int compareTo(Object signals) {
        return cleanId(this.beaconId) - (cleanId(((Signals)signals).getBeaconId()));
    }

    private Integer cleanId(String id) {
        return Integer.parseInt(id.replace("Beacon", ""));
    }
}
