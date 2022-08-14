package com.example.kursachjavafx.DrawingCanvas;


import com.example.kursachjavafx.Point;
import javafx.scene.paint.Color;

import java.util.List;

public interface DrawingCanvas {

    void drawLine(Point from, Point to, Point color);

    void drawLines(List<Point> points, Point color);

    void clear();
}
