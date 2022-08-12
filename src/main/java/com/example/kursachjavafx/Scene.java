package com.example.kursachjavafx;

import com.example.kursachjavafx.Figure.Figure;

import java.util.List;
import java.util.stream.Collectors;

public class Scene {
    private Camera camera;
    private List<Figure> figures;

    private Scene(){}

    private Scene(Camera camera, List<Figure> figures) {
        this.camera = camera;
        this.figures = figures;
    }

    private Scene(Camera camera) {
        this.camera = camera;
    }

    public Camera getCamera() {
        return camera;
    }

    public List<Figure> getFigures() {
        return figures;
    }

    public List<Figure> getPreparedFigures() {
        var newList = figures.stream().parallel().map(x -> x.clone()).collect(Collectors.toList());
        newList.stream().parallel().forEach(x -> camera.apply(x));
        return newList;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void setFigures(List<Figure> figures) {
        this.figures = figures;
    }

    public static class Builder {
        Scene scene = new Scene();

        public Builder setCamera(Camera camera) {
            scene.camera = camera;
            return this;
        }

        public Builder setFigures(List<Figure> figures) {
            scene.figures = figures;
            return this;
        }

        public Scene build() {
            return scene;
        }

    }
}
