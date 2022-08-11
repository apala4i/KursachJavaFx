package com.example.kursachjavafx;

import org.ejml.simple.SimpleMatrix;

public class Point {
    private SimpleMatrix matrix = new SimpleMatrix(1, 4);

    public Point() {
        this(0, 0, 0, 1);
    }

    public Point(double x, double y, double z, double scaleCoefficient) {
        matrix.set(0, 0, x);
        matrix.set(0, 1, y);
        matrix.set(0, 2, z);
        matrix.set(0, 3, scaleCoefficient);
    }

    public Point(double x, double y, double z) {
        this(x, y, z, 1);
    }

    public SimpleMatrix getMatrix() {
        return matrix;
    }

    public void setMatrix(SimpleMatrix matrix) {
        this.matrix = matrix;
    }

    public double getX() {
        return matrix.get(0, 0);
    }

    public double getY() {
        return matrix.get(0, 1);
    }

    public double getZ() {
        return matrix.get(0, 2);
    }

    public double getScaleCoefficient() {
        return matrix.get(1, 4);
    }


}
