package com.example.kursachjavafx.command.Camera;

import com.example.kursachjavafx.Camera;
import com.example.kursachjavafx.command.Command;

public abstract class CameraCommand implements Command {
    private Camera camera;

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
