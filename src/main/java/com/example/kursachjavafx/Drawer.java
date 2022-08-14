package com.example.kursachjavafx;

import com.example.kursachjavafx.DrawingCanvas.DrawingCanvas;

public class Drawer {
    private Scene scene;
    private DrawingCanvas canvas;

    public Scene getScene() {
        return scene;
    }

    public DrawingCanvas getCanvas() {
        return canvas;
    }

    public void draw() {
        scene.getPreparedFigures().forEach(x -> x.draw(canvas));
    }

    public static class Builder{
        Drawer drawer = new Drawer();

        public Builder setScene(Scene scene) {
            drawer.scene = scene;
            return this;
        }

        public Builder setDrawingCanvas(DrawingCanvas drawingCanvas) {
            drawer.canvas = drawingCanvas;
            return this;
        }

        public Drawer build() {
            return drawer;
        }
    }
}
