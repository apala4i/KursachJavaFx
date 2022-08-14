package com.example.kursachjavafx.DrawingCanvas;

import com.example.kursachjavafx.Point;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.List;

public class JavaFxCanvas implements DrawingCanvas{
    Canvas canvas;

    public JavaFxCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void drawLine(Point from, Point to, Point color) {
        var gc = canvas.getGraphicsContext2D();
        gc.setStroke(new Color(color.getX(), color.getY(), color.getZ(), 1));
        gc.strokeLine(from.getX(), from.getY(), to.getX(), to.getY());
        gc.save();
    }

    @Override
    public void drawLines(List<Point> points, Point color) {
        var gc = canvas.getGraphicsContext2D();
        gc.setStroke(new Color(color.getX(), color.getY(), color.getZ(), 1));
        for (int i = 0; i < points.size() - 1; ++i) {
            gc.strokeLine(points.get(i).getX(), points.get(i).getY(),
                    points.get(i + 1).getX(), points.get(i + 1).getY());
        }
        gc.save();
    }

    @Override
    public void clear() {
        var gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.save();
    }
}
