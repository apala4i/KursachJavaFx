package com.example.kursachjavafx;

import com.example.kursachjavafx.Director.FacadeDirector;
import com.example.kursachjavafx.command.Camera.RotateCamera;
import com.example.kursachjavafx.command.Camera.TransferCamera;
import com.example.kursachjavafx.command.Figure.RotateFigure;
import com.example.kursachjavafx.command.Figure.TransferFigure;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

public class FxController {

    @FXML
    private Canvas canvas;

    private Facade facade;

    @FXML
    public void initialize() {
        facade = FacadeDirector.defaultFacade(canvas);
        facade.draw();
    }

    @FXML
    private  Button startButton;

    public  void buttonPressed(ActionEvent actionEvent) {
        var thread =new Thread() {
           @Override
           public void run() {
               while (true) {
                   facade.clear();
                   facade.execute(new RotateFigure(new Point(10, 10, 0), new Point(75, 75, 0)));
                   facade.draw();
                   try {
                       Thread.sleep(75);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
        };

        thread.start();
    }

}