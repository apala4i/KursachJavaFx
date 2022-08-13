package com.example.kursachjavafx.Transformations;

import com.example.kursachjavafx.Point;
import org.ejml.simple.SimpleMatrix;

import java.util.List;

public class TransformationMatrix {
    private SimpleMatrix transformMatrix;

    public TransformationMatrix(SimpleMatrix simpleMatrix) {
        this.transformMatrix = simpleMatrix;
    }
    private TransformationMatrix(){};


    public SimpleMatrix getTransformMatrix() {
        return transformMatrix;
    }

    public static class RotateMatrix extends TransformationMatrix {
        public void Perform(List<Point> points, Point center) {
            var backMatrix = transferMatrix(-center.getX(), -center.getY(), -center.getZ());
            backMatrix.perform(points);

        }
    }

    public static TransformationMatrix transferMatrix(double dx, double dy, double dz) {
        return new TransformationMatrix(new SimpleMatrix(new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {dx, dy, dz, 1}}
                ));
    }

    public static TransformationMatrix transferMatrix(Point point) {
        return transferMatrix(point.getX(), point.getY(), point.getZ());
    }

    public static TransformationMatrix scaleMatrix(Point scale) {
        return scaleMatrix(scale, new Point(0, 0, 0));
    }

    public static TransformationMatrix scaleMatrix(Point scale, Point center) {
        var scaleMatrix = new TransformationMatrix(new SimpleMatrix(new double[][]{
                {scale.getX(), 0, 0, 0},
                {0, scale.getY(), 0, 0},
                {0, 0, scale.getZ(), 0},
                {0, 0, 0, 1}}
        ));
        return transformationMatrixWithCenter(scaleMatrix, center);
    }



    public static TransformationMatrix rotateMatrix(Point angles, Point center) {
        var rotateX = rotateXMatrix(angles.getX());
        var rotateY = rotateYMatrix(angles.getY());
        var rotateZ = rotateZMatrix(angles.getZ());

        var complexRotate = new TransformationMatrix(rotateX.transformMatrix
                .mult(rotateY.transformMatrix).mult(rotateZ.transformMatrix));

        return transformationMatrixWithCenter(complexRotate, center);
    }


    // X rotation
    public static TransformationMatrix rotateXMatrix(double angle, Point center) {
        return transformationMatrixWithCenter( new TransformationMatrix(new SimpleMatrix(new double[][]{
                {1, 0, 0, 0},
                {0, Math.cos(Math.toRadians(angle)), Math.sin(Math.toRadians(angle)), 0},
                {0, -Math.sin(Math.toRadians(angle)), Math.cos(Math.toRadians(angle)), 0},
                {0, 0, 0, 1}}
        )), center);
    }

    public static TransformationMatrix rotateXMatrix(double angle) {
        return new TransformationMatrix(new SimpleMatrix(new double[][]{
                {1, 0, 0, 0},
                {0, Math.cos(Math.toRadians(angle)), Math.sin(Math.toRadians(angle)), 0},
                {0, -Math.sin(Math.toRadians(angle)), Math.cos(Math.toRadians(angle)), 0},
                {0, 0, 0, 1}}
        ));
    }



    // Y rotation
    public static TransformationMatrix rotateYMatrix(double angle, Point center) {
        return transformationMatrixWithCenter( new TransformationMatrix(new SimpleMatrix(new double[][]{
                {Math.cos(Math.toRadians(angle)), 0, -Math.sin(Math.toRadians(angle)), 0},
                {0, 1, 0, 0},
                {Math.sin(Math.toRadians(angle)), 0, Math.cos(Math.toRadians(angle)), 0},
                {0, 0, 0, 1}}
        )), center);
    }

    public static TransformationMatrix rotateYMatrix(double angle) {
        return new TransformationMatrix(new SimpleMatrix(new double[][]{
                {Math.cos(Math.toRadians(angle)), 0, -Math.sin(Math.toRadians(angle)), 0},
                {0, 1, 0, 0},
                {Math.sin(Math.toRadians(angle)), 0, Math.cos(Math.toRadians(angle)), 0},
                {0, 0, 0, 1}}
        ));
    }



    // Z rotation
    public static TransformationMatrix rotateZMatrix(double angle, Point center) {
        return transformationMatrixWithCenter( new TransformationMatrix(new SimpleMatrix(new double[][]{
                {Math.cos(Math.toRadians(angle)), Math.sin(Math.toRadians(angle)), 0, 0},
                {-Math.sin(Math.toRadians(angle)), Math.cos(Math.toRadians(angle)), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}}
        )), center);
    }

    public static TransformationMatrix rotateZMatrix(double angle) {
        return new TransformationMatrix(new SimpleMatrix(new double[][]{
                {Math.cos(Math.toRadians(angle)), Math.sin(Math.toRadians(angle)), 0, 0},
                {-Math.sin(Math.toRadians(angle)), Math.cos(Math.toRadians(angle)), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}}
        ));
    }


    // Base rotation with center
    public static TransformationMatrix transformationMatrixWithCenter(TransformationMatrix matrix, Point center) {
        var moveBack = transferMatrix(-center.getX(), -center.getY(), -center.getZ());
        var moveForward = transferMatrix(center);

        return new TransformationMatrix
                (moveBack.transformMatrix.mult(matrix.transformMatrix).mult(moveForward.transformMatrix));
    }




    public void perform(List<Point> points) {
        points.stream().parallel().forEach(x -> x.setMatrix(x.getMatrix().mult(transformMatrix)));
    }

}
