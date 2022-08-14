package com.example.kursachjavafx.command.Figure;

import com.example.kursachjavafx.Figure.Figure;
import com.example.kursachjavafx.command.Command;

public abstract class FigureCommand implements Command {
    private Figure[] figures;

    public void setFigures(Figure[] figures) {
        this.figures = figures;
    }

    public Figure[] getFigures() {
        return figures;
    }
}
