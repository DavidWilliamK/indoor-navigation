package com.binus.indoornavigation.web_model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionWebRequest {

    private int latitude;
    private int longitude;

}
