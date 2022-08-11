package com.example.kursachjavafx.frameModel;

import com.example.kursachjavafx.Point;

import java.util.ArrayList;
import java.util.List;

public class FrameModel {
    private List<Point> points;
    private Point center;

    private FrameModel(List<Point> points, Point center) {
        this.points = points;
    }

    public static FrameModel getSquare() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(50, 50, 50));
        points.add(new Point(100, 50, 50));
        points.add(new Point(100, 100, 50));
        points.add(new Point(50, 100, 50));
        return new FrameModel(points, new Point(75, 75, 75));
    }

    public List<Point> getPoints() {
        return points;
    }
}
