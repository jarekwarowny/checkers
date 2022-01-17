package com.kodilla.checkers;

public class Pawn implements Figure {

    private FigureColor color;

    @Override
    public FigureColor getColor() {
        return color;
    }

    public Pawn(FigureColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return ((color == FigureColor.BLUE) ? "w" : "b") + "P";
    }
}
