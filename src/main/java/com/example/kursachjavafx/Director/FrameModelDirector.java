package com.example.kursachjavafx.Director;

import com.example.kursachjavafx.Figure.Figure;
import com.example.kursachjavafx.Figure.frameModel.FrameModel;
import com.example.kursachjavafx.Point;

import java.util.ArrayList;
import java.util.List;

public class FrameModelDirector {
    public static Figure square() {
            List<Point> points = new ArrayList<>();
            points.add(new Point(50, 50, 50));
            points.add(new Point(100, 50, 50));
            points.add(new Point(100, 100, 50));
            points.add(new Point(50, 100, 50));

            return new FrameModel.Builder()
                    .setPoints(points)
                    .setCenter(new Point(75, 75, 75))
                    .setColor(new Point(0, 0, 0))
                    .build();
    }
}
