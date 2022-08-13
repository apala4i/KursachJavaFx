package com.example.kursachjavafx.Figure.frameModel;

import com.example.kursachjavafx.DrawingCanvas.DrawingCanvas;
import com.example.kursachjavafx.Figure.Figure;
import com.example.kursachjavafx.Point;

import java.util.ArrayList;
import java.util.List;

public class FrameModel implements Figure {
    private List<Point> points;
    private Point center = new Point(0, 0, 0);
    private Point color = new Point(0, 0, 0);

    public Point getCenter() {
        return center;
    }

    private FrameModel(){}

    private FrameModel(List<Point> points) {
        this.points = points;
    }

    private FrameModel(List<Point> points, Point center) {
        this.points = points;
        this.center = center;
    }

    public Figure clone() {
        return new FrameModel(new ArrayList<>(points), center);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public void draw(DrawingCanvas drawingCanvas) {
        for (int i = 0; i < points.size(); ++i) {
            drawingCanvas.drawLine(points.get(i), points.get((i + 1) % points.size()), color);
        }
    }

    public static class Builder {
        FrameModel figure = new FrameModel();

        public Builder setPoints(List<Point> points) {
            figure.points = points;
            return this;
        }

        public Builder setCenter(Point center) {
            figure.center = center;
            return this;
        }

        public Builder setColor(Point color) {
            figure.color = color;
            return this;
        }

        public FrameModel build() {
            return figure;
        }

    }
}
