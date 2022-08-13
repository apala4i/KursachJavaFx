package com.example.kursachjavafx;

import com.example.kursachjavafx.Figure.Figure;
import com.example.kursachjavafx.Transformations.TransformationMatrix;
import org.ejml.simple.SimpleMatrix;

public class Camera {
    private Point angles;
    private Point position;

    private TransformationMatrix cameraMatrix;

    public Camera() {}

    public void update() {
        var positionMatrix = TransformationMatrix.transferMatrix(position);
        var anglesMatrix =
                TransformationMatrix.rotateMatrix(angles, new Point(0, 0, 0));
        cameraMatrix = new TransformationMatrix
                (positionMatrix.getTransformMatrix().mult(anglesMatrix.getTransformMatrix()));
    }

    public Camera(Point angles, Point position) {
        this.angles = angles;
        this.position = position;


    }

    public void apply(Figure figure) {
        update();
        cameraMatrix.perform(figure.getPoints());
    }

    public Point getAngles() {
        return angles;
    }

    public Point getPosition() {
        return position;
    }

    public void setAngles(Point angles) {
        this.angles = angles;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public static class Builder {
        Camera camera = new Camera();

        public Builder setAngles(Point angles) {
            camera.angles = angles;
            return this;
        }

        public Builder setPosition(Point position) {
            camera.position = position;
            return this;
        }

        public Camera build() {
            camera.update();
            return camera;
        }
    }
}
