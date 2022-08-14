package com.example.kursachjavafx.command.Figure;

import com.example.kursachjavafx.Figure.Figure;
import com.example.kursachjavafx.Point;
import com.example.kursachjavafx.command.Command;
import com.example.kursachjavafx.manager.Figure.FigureReformManager;

public class TransferFigure extends FigureCommand {
    private final Point transfer;

    public TransferFigure(Point transfer) {
        this.transfer = transfer;

    }

    @Override
    public void execute() {
        FigureReformManager.transferFigure(transfer, getFigures());
    }
}
