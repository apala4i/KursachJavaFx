package com.example.kursachjavafx.command.Figure;

import com.example.kursachjavafx.Figure.Figure;
import com.example.kursachjavafx.Point;
import com.example.kursachjavafx.command.Command;
import com.example.kursachjavafx.manager.Figure.FigureReformManager;

import java.util.Arrays;

public class RotateFigure extends FigureCommand {

    private final Point angles;
    private final Point center;

    public RotateFigure(Point angles, Point center) {
        this.center = center;
        this.angles = angles;
    }

    @Override
    public void execute() {
        FigureReformManager.rotateFigure(angles, center, getFigures());
    }
}
