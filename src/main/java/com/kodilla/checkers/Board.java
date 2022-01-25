package com.kodilla.checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class Board extends JPanel implements ActionListener, MouseListener {

    boolean gameInProgress;
    int currentPlayer;
    int selectedRow;
    int selectedCol;
    Move[] legalMoves;
    Figure figure;


    private final List<BoardRow> rows = new ArrayList<>();

    public static final int ROWS_NUM = 8;


    public Board() {
        for (int i = 0; i < ROWS_NUM; i++) {
            rows.add(new BoardRow());
        }
        initialSetup();
        addMouseListener(this);
        doNewGame();
        doResigne();
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
        Figure figure = getFigure(row1, col1);
        setFigure(row2, col2, figure);
        setFigure(row1, col1, new None());
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

    private void doNewGame() {
        if (gameInProgress == true) {
            System.out.println("Rozgrywka trwa");
        }
    }

    private void doResigne() {
        if (gameInProgress == false) {
            System.out.println("Gra nie rozpoczęta");
        } else if (currentPlayer == ) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        JButton newGameButton = new JButton("Nowa gra");
        JButton resignButton = new JButton("Rezygnacja");
        resignButton.addActionListener(this);
        newGameButton.addActionListener(this);
        if (src == newGameButton) {
            doNewGame();
        } else if (src == resignButton) {
            doResigne();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
