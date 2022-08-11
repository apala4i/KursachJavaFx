package com.example.kursachjavafx;

public class Camera {
    private Point angles;
    private Point position;

    public Camera(Point angles, Point position) {
        this.angles = angles;
        this.position = position;
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
}
