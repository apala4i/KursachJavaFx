package com.example.kursachjavafx;

import java.util.List;

public class Scene {
    private Camera camera;
    private List<Point> lines;


    public Scene(Camera camera, List<Point> lines) {
        this.camera = camera;
        this.lines = lines;
    }

    public Camera getCamera() {
        return camera;
    }

    public List<Point> getLines() {
        return lines;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void setLines(List<Point> lines) {
        this.lines = lines;
    }
}
