package com.example.kursachjavafx;

import com.example.kursachjavafx.Figure.Figure;
import com.example.kursachjavafx.command.Camera.CameraCommand;
import com.example.kursachjavafx.command.Command;
import com.example.kursachjavafx.command.Figure.FigureCommand;
import com.example.kursachjavafx.command.Figure.RotateFigure;
import com.example.kursachjavafx.command.Figure.ScaleFigure;

import java.util.List;

public class Facade {
    private final Drawer drawer;

    public Facade(Drawer drawer) {
        this.drawer = drawer;
    }

    public void draw() {
        drawer.draw();
    }

    public void clear() {
        drawer.getCanvas().clear();
    }

    public void execute(CameraCommand cameraCommand) {
        cameraCommand.setCamera(drawer.getScene().getCamera());
        cameraCommand.execute();
    }

    public void execute(FigureCommand figureCommand) {
        List<Figure> figures = drawer.getScene().getFigures();
        figureCommand.setFigures(figures.toArray(new Figure[figures.size()]));
        figureCommand.execute();
    }

}
