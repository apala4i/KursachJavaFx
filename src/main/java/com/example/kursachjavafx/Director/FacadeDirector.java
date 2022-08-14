package com.example.kursachjavafx.Director;

import com.example.kursachjavafx.Facade;
import javafx.scene.canvas.Canvas;

public class FacadeDirector {
    public static Facade defaultFacade(Canvas canvas) {
        return new Facade(DrawerDirector.defaultDrawer(canvas));
    }
}
