package com.example.kursachjavafx.command.Camera;

import com.example.kursachjavafx.Camera;
import com.example.kursachjavafx.Point;
import com.example.kursachjavafx.command.Command;
import com.example.kursachjavafx.manager.Figure.CameraPerformManager;

public class RotateCamera extends CameraCommand {

    private final Point rotation;

    public RotateCamera(Point rotation) {
        this.rotation = rotation;
    }

    @Override
    public void execute() {
        CameraPerformManager.rotateCamera(getCamera(), rotation);
    }
}
