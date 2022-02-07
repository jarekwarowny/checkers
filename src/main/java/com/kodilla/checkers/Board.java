package com.kodilla.checkers;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<BoardRow> rows = new ArrayList<>();
    public static final int ROWS_NUM = 8;

    public Board() {
        for (int i = 0; i < ROWS_NUM; i++) {
            rows.add(new BoardRow());
        }
        initialSetup();
    }

    public Figure getFigure(int row, int col) {
        return rows.get(row).getFigure(col);
    }

    public void setFigure(int row, int col, Figure figure) {
        rows.get(row).setFigure(col, figure);
    }

    public boolean move(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || col1 >= rows.get(row1).getSize()) {
            return false;
        } else if (col1 < 0 || col1 >= rows.size()) {
            return false;
        } else if (row2 < 0 || col2 >= rows.get(row2).getSize()) {
            return false;
        } else if (col2 < 0 || row2 >= rows.size()) {
            return false;
        } else if (row1 == row2 || col1 == col2) {
            return false;
        } else if (Math.abs(row2 - row1) != 1 || Math.abs(col2 - col1) != 1) {
            return false;
        }

        Figure fieldToGo = rows.get(row2).getFigure(col2);
        Figure figure = getFigure(row1, col1);
        if (fieldToGo instanceof None) {
            setFigure(row2, col2, figure);
            setFigure(row1, col1, fieldToGo);
        } else if (!fieldToGo.getColor().equals(figure.getColor())) {
            int row3 = row2 + (row2 - row1);
            int col3 = col2 + (col2 - col1);
            if (row3 < 0 || col3 >= rows.get(row3).getSize()) {
                return false;
            } else if (col3 < 0 || row3 >= rows.size()) {
                return false;
            }

            Figure finishFigure = rows.get(row3).getFigure(col3);
            if (finishFigure instanceof None) {
                setFigure(row2, col2, new None());
                setFigure(row1, col1, finishFigure);
                setFigure(row3, col3, figure);
                if (checkIfSomeoneWin()) {
                    return true;
                }
            }
        }
        return false;
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

    public void initialSetup() {
        this.setFigure(0, 0, new Pawn(FigureColor.BLUE));
        this.setFigure(0, 2, new Pawn(FigureColor.BLUE));
        this.setFigure(0, 4, new Pawn(FigureColor.BLUE));
        this.setFigure(0, 6, new Pawn(FigureColor.BLUE));
        this.setFigure(1, 1, new Pawn(FigureColor.BLUE));
        this.setFigure(1, 3, new Pawn(FigureColor.BLUE));
        this.setFigure(1, 5, new Pawn(FigureColor.BLUE));
        this.setFigure(1, 7, new Pawn(FigureColor.BLUE));
        this.setFigure(2, 0, new Pawn(FigureColor.BLUE));
        this.setFigure(2, 2, new Pawn(FigureColor.BLUE));
        this.setFigure(2, 4, new Pawn(FigureColor.BLUE));
        this.setFigure(2, 6, new Pawn(FigureColor.BLUE));

        this.setFigure(6, 0, new Pawn(FigureColor.BROWN));
        this.setFigure(6, 2, new Pawn(FigureColor.BROWN));
        this.setFigure(6, 4, new Pawn(FigureColor.BROWN));
        this.setFigure(6, 6, new Pawn(FigureColor.BROWN));
        this.setFigure(7, 1, new Pawn(FigureColor.BROWN));
        this.setFigure(7, 3, new Pawn(FigureColor.BROWN));
        this.setFigure(7, 5, new Pawn(FigureColor.BROWN));
        this.setFigure(7, 7, new Pawn(FigureColor.BROWN));
        this.setFigure(5, 1, new Pawn(FigureColor.BROWN));
        this.setFigure(5, 3, new Pawn(FigureColor.BROWN));
        this.setFigure(5, 5, new Pawn(FigureColor.BROWN));
        this.setFigure(5, 7, new Pawn(FigureColor.BROWN));
    }

    public boolean checkIfSomeoneWin() {
        int brownCounter = 0;
        int blueCounter = 0;
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row <8; row++) {
                FigureColor fc = rows.get(row).getFigure(col).getColor();
                if (fc.equals(FigureColor.BROWN)) {
                    brownCounter++;
                } else if (fc.equals(FigureColor.BLUE)) {
                    blueCounter++;
                }
            }
        }

        if (blueCounter == 0) {
            System.out.println("Brown won");
            return true;
        } else if (brownCounter == 0) {
            System.out.println("Blue won");
            return true;
        }
        return false;
    }
}

