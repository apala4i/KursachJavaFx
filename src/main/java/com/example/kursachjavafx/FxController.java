package com.example.kursachjavafx;

import com.example.kursachjavafx.Transformations.TransformationMatrix;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import com.example.kursachjavafx.frameModel.FrameModel;

public class FxController {

    @FXML
    private  Canvas mainCanvas;

    @FXML
    private  Button startButton;

    private FrameModel square = FrameModel.getSquare();

    public void drawLine(Point from, Point to) {
        var graphicsContext = mainCanvas.getGraphicsContext2D();
        graphicsContext.strokeLine(from.getX(), from.getY(), to.getX(), to.getY());
        graphicsContext.save();
    }

    public void drawFrameModel(FrameModel frameModel) {
        var graphicsContext = mainCanvas.getGraphicsContext2D();
        var points = frameModel.getPoints();
        for (int i = 0; i < points.size(); ++i) {
            drawLine(points.get(i), points.get((i + 1) % points.size()));
        }
        graphicsContext.save();
    }

    public void basicAction(FrameModel frameModel, TransformationMatrix transformationMatrix) {
        transformationMatrix.perform(frameModel.getPoints());
    }

    public  void buttonPressed(ActionEvent actionEvent) {
        var graphicsContext = mainCanvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, Configs.APPLICATION_WINDOW_WIDTH, Configs.APPLICATION_WINDOW_HEIGHT);
        drawFrameModel(square);
        TransformationMatrix.rotateYMatrix(15).perform(square.getPoints());
        graphicsContext.save();
    }



}