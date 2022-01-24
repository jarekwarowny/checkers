package com.kodilla.checkers;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {

    private final List<Figure> figures = new ArrayList<>();
    public static final int COLUMNS_NUM = 8;

    public BoardRow() {
        for (int i = 0; i < COLUMNS_NUM; i++) {
            figures.add(new None());
        }
    }

    public Figure getFigure(int col) {
        return figures.get(col);
    }

    public void setFigure(int col, Figure figure) {
        figures.set(col, figure);
    }

    public int getSize() {
        return figures.size();
    }

    @Override
    public String toString() {
       String row = "|";
       for (int n = 0; n < COLUMNS_NUM; n++) {
           row += figures.get(n).toString() + "|";
       }
       return row;
    }
}
