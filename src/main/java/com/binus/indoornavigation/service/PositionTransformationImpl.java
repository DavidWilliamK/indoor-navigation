package com.binus.indoornavigation.service;

import com.binus.indoornavigation.model.Coordinate;
import com.binus.indoornavigation.model.Position;
import com.binus.indoornavigation.model.enums.Binus;
import org.springframework.stereotype.Service;

@Service
public class PositionTransformationImpl {

    double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }

        return result;
    }

    public Position getTransformedPosition (Coordinate coordinate) {

//        Operation to transform coordinate (X-axis, Y-axis) to position (Latitude, Longitude)
//        Note that this is still a dummy function which will return the position of a random Binus' campus
        System.out.println(coordinate.getX() + ", " + coordinate.getY());
        double[][] localCoordinate = {
                new double[]{coordinate.getX()},
                new double[]{coordinate.getY()},
                new double[]{1d}
        };
        double[][] transformation = {
                new double[]{-1.20639801e-07, -1.09672546e-08, -6.20178413e+00},
                new double[]{-8.39233398e-08,  -8.39233398e-08, 1.06781860e+02}
        };

        double[][] latLong = multiplyMatrices(transformation, localCoordinate);

        Position actCoordinate = new Position(latLong[0][0], latLong[1][0]);

        System.out.println(actCoordinate);

        return actCoordinate;

    }
}
