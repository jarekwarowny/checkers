package com.kodilla.checkers;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<BoardRow> rows = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 8; i++) {
            rows.add(new BoardRow());
        }
    }

    public Figure getFigure(int row, int col) {
        return rows.get(row).getFigure(col);
    }

    public void setFigure(int row, int col, Figure figure) {
        rows.get(row).setFigure(col, figure);
    }

    boolean move(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || row1 >= rows.get(col1).getSize()) {
            return false;
        } else if (col1 < 0 || col1 >= rows.size()) {
            return false;
        } else if (row2 < 0 || row2 >= rows.get(col2).getSize()) {
            return false;
        } else if (col2 < 0 || col2 >= rows.size()) {
            return false;
        }
        Figure figure = getFigure(row1,col1);
        setFigure(row2,col2, figure);
        setFigure(row1,col1, new None());
        return true;
    }

    @Override
    public String toString() {
        String board = "-------------------------\n";
        for (int i = 0; i < rows.size(); i++) {
            board += rows.get(i).toString() + "\n";
        }
        board += "-------------------------\n";
        return board;
    }
}
