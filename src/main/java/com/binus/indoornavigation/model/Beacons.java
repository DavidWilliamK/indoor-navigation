package com.binus.indoornavigation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beacons implements Comparable{

    private String id;

    private Double RSSI;

    @Override
    public int compareTo(Object beacons) {
        Double compareRssi = ((Beacons)beacons).getRSSI();
        return (int)(compareRssi-this.RSSI);
    }
}
