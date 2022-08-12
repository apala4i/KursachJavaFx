package com.example.kursachjavafx.Figure;

import com.example.kursachjavafx.DrawingCanvas.DrawingCanvas;
import com.example.kursachjavafx.Point;

import java.util.List;

public interface Figure extends Cloneable {
    List<Point> getPoints();
    void draw(DrawingCanvas drawingCanvas);
    Figure clone();
}
