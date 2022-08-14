package com.example.kursachjavafx.manager.Figure;

import com.example.kursachjavafx.Camera;
import com.example.kursachjavafx.Point;

public class CameraPerformManager {
    public static void rotateCamera(Camera camera, Point rotation) {
        camera.getAngles().plus(rotation);
    }

    public static void transferCamera(Camera camera, Point transfer) {
        camera.getPosition().plus(transfer);
    }
}
