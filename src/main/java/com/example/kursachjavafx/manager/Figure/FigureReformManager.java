package com.example.kursachjavafx.manager.Figure;

import com.example.kursachjavafx.Figure.Figure;
import com.example.kursachjavafx.Point;
import com.example.kursachjavafx.Transformations.TransformationMatrix;

import java.util.Arrays;

public class FigureReformManager {

    private static void applyTransformation(TransformationMatrix matrix, Figure... figures) {
        Arrays.stream(figures).parallel().forEach(x -> matrix.perform(x.getPoints()));
    }

    public static void rotateFigure(Point angles, Point center, Figure... figures) {
        applyTransformation(TransformationMatrix.rotateMatrix(angles, center), figures);
    }

    public static void scaleFigure(Point scale, Point center, Figure... figures) {
        applyTransformation(TransformationMatrix.scaleMatrix(scale, center), figures);
    }

    public static void transferFigure(Point transfer, Figure... figures) {
        applyTransformation(TransformationMatrix.transferMatrix(transfer), figures);
    }


}
