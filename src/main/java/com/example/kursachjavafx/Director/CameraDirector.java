package com.example.kursachjavafx.Director;

import com.example.kursachjavafx.Camera;
import com.example.kursachjavafx.Point;

public class CameraDirector {
    public static Camera defaultCamera() {
        var builder = new Camera.Builder();
        return builder.setAngles(new Point(0, 0, 0)).setPosition(new Point(0, 0, 0)).build();
    }
}
