package com.kodilla.gfx;

import com.kodilla.checkers.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameController {
    private static final Image IMAGE_PAWN_BLUE = new Image("file:src/main/resources/pionek-niebieski2.png");
    private static final Image IMAGE_PAWN_BROWN = new Image("file:src/main/resources/pionek-brazowy2.png");
    private Board board;
    private GridPane grid;
    private int oldx = -1;
    private int oldy = -1;

    public GameController(Board board, GridPane grid) {
        this.board = board;
        this.grid = grid;
    }

    public void display() {
        grid.getChildren().clear();
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row <8; row++) {
                Figure figure = board.getFigure(row, col);
                Image image = null;
                if (figure instanceof Pawn) {
                    if (figure.getColor() == FigureColor.BLUE) {
                        image = IMAGE_PAWN_BLUE;
                     } else {
                        image = IMAGE_PAWN_BROWN;
                    }
                } else if (figure instanceof Queen) {

                }
                grid.add(new ImageView(image),col,row);
                if (col == oldx && row == oldy) {
                    Rectangle rectangle = new Rectangle(100,100, Color.RED);
                    grid.add(rectangle,col,row);
                }
            }
        }
    }

    public void doClick(int x, int y) {
        if (oldx == -1) {
            if (!(board.getFigure(y,x) instanceof None)) {
                oldx = x;
                oldy = y;
                display();
            }
        } else {
            boolean gameEnd = board.move(oldy,oldx,y,x);
            if (gameEnd) {
                System.out.println("The end");
            }
            oldx = -1;
            display();
        }
    }
}
