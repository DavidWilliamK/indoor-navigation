package com.binus.indoornavigation.model.enums;

import com.binus.indoornavigation.model.Position;
import lombok.Getter;

@Getter
public enum Binus {

    ANGGREK(-6.201894, 106.781713),
    SYAHDAN(-6.200239, 106.785473),
    KIJANG(-6.193907, 106.788135),
    ALSUT(-6.222345, 106.649170),
    ASO(-6.240554, 106.657372);

    private Position campus;

    Binus(Double latitude, Double longitude) {
        this.campus = new Position(latitude, longitude);
    }

}
