package com.example.kursachjavafx.Director;

import com.example.kursachjavafx.Drawer;
import com.example.kursachjavafx.DrawingCanvas.DrawingCanvas;
import com.example.kursachjavafx.DrawingCanvas.JavaFxCanvas;
import com.example.kursachjavafx.Scene;
import javafx.scene.canvas.Canvas;

public class DrawerDirector {
    public static Drawer defaultDrawer(Canvas canvas) {
        Scene scene = SceneDirector.defaultScene();
        DrawingCanvas drawingCanvas = new JavaFxCanvas(canvas);
        return new Drawer.Builder().setScene(scene).setDrawingCanvas(drawingCanvas).build();
    }
}
