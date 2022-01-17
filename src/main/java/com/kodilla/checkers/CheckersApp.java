package com.kodilla.checkers;

import javafx.application.Application;
import javafx.stage.Stage;

public class CheckersApp {

    public static void main(String[] args) {
        Board board = new Board();
        board.setFigure(1,4, new Queen(FigureColor.BROWN));
        board.setFigure(2,4, new Pawn(FigureColor.BLUE));
        System.out.println(board);
        board.move(2,4, 3,3);
        System.out.println(board);
    }
}