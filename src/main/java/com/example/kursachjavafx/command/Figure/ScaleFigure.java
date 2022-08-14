package com.example.kursachjavafx.command.Figure;

import com.example.kursachjavafx.Figure.Figure;
import com.example.kursachjavafx.Point;
import com.example.kursachjavafx.command.Command;
import com.example.kursachjavafx.manager.Figure.FigureReformManager;

public class ScaleFigure extends FigureCommand {
    private final Point scale;
    private final Point center;

    public ScaleFigure(Point scale, Point center) {
        this.center = center;
        this.scale = scale;
    }

    @Override
    public void execute() {
        FigureReformManager.scaleFigure(scale, center, getFigures());
    }
}
