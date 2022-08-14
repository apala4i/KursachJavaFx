package com.example.kursachjavafx.command.Camera;

import com.example.kursachjavafx.Camera;
import com.example.kursachjavafx.Point;
import com.example.kursachjavafx.command.Command;
import com.example.kursachjavafx.manager.Figure.CameraPerformManager;

public class TransferCamera extends CameraCommand {

    private final Point transfer;

    public TransferCamera(Point transfer) {
        this.transfer = transfer;
    }

    @Override
    public void execute() {
        CameraPerformManager.transferCamera(getCamera(), transfer);
    }
}
