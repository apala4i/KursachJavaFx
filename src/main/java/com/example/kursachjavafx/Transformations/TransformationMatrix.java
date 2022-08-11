package com.example.kursachjavafx.Transformations;

import com.example.kursachjavafx.Point;
import org.ejml.simple.SimpleMatrix;

import java.util.List;

public class TransformationMatrix {
    private final SimpleMatrix transformMatrix;

    private TransformationMatrix(SimpleMatrix simpleMatrix) {
        this.transformMatrix = simpleMatrix;
    }

    public static TransformationMatrix transferMatrix(double dx, double dy, double dz) {
        return new TransformationMatrix(new SimpleMatrix(new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {dx, dy, dz, 1}}
                ));
    }

    public static TransformationMatrix scaleMatrix(double sx, double sy, double sz) {
        return new TransformationMatrix(new SimpleMatrix(new double[][]{
                {sx, 0, 0, 0},
                {0, sy, 0, 0},
                {0, 0, sz, 0},
                {0, 0, 0, 1}}
        ));
    }

    public static TransformationMatrix rotateZMatrix(double angle) {
        return new TransformationMatrix(new SimpleMatrix(new double[][]{
                {Math.cos(Math.toRadians(angle)), Math.sin(Math.toRadians(angle)), 0, 0},
                {-Math.sin(Math.toRadians(angle)), Math.cos(Math.toRadians(angle)), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}}
        ));
    }

    public static TransformationMatrix rotateXMatrix(double angle) {
        return new TransformationMatrix(new SimpleMatrix(new double[][]{
                {1, 0, 0, 0},
                {0, Math.cos(Math.toRadians(angle)), Math.sin(Math.toRadians(angle)), 0},
                {0, -Math.sin(Math.toRadians(angle)), Math.cos(Math.toRadians(angle)), 0},
                {0, 0, 0, 1}}
        ));
    }

    public static TransformationMatrix rotateYMatrix(double angle) {
        return new TransformationMatrix(new SimpleMatrix(new double[][]{
                {Math.cos(Math.toRadians(angle)), 0, -Math.sin(Math.toRadians(angle)), 0},
                {0, 1, 0, 0},
                {Math.sin(Math.toRadians(angle)), 0, Math.cos(Math.toRadians(angle)), 0},
                {0, 0, 0, 1}}
        ));
    }



    public void perform(List<Point> points) {
        points.stream().parallel().forEach(x -> x.setMatrix(x.getMatrix().mult(transformMatrix)));
    }

}
