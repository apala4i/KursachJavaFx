package com.example.kursachjavafx.Director;

import com.example.kursachjavafx.Camera;
import com.example.kursachjavafx.Figure.Figure;
import com.example.kursachjavafx.Scene;

import java.util.ArrayList;
import java.util.List;

public class SceneDirector {
    public static Scene defaultScene() {
        Camera camera = CameraDirector.defaultCamera();
        List<Figure> figures = new ArrayList<>();
        figures.add(FrameModelDirector.square());

        return new Scene.Builder().setCamera(camera).setFigures(figures).build();

    }
}
