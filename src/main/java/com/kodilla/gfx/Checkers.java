package com.kodilla.gfx;

import com.kodilla.checkers.Board;
import com.kodilla.checkers.BoardRow;
import com.kodilla.checkers.Figure;
import com.kodilla.checkers.None;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Checkers extends Application {

    private Image imageback = new Image("file:src/main/resources/WARCABY-scaled.jpg");
    //private Image image = new Image("file:src/main/resources/pionek-czarny.pg");
    private final ImageView view = new ImageView();
    private final Board board = new Board();
    private static final int BASE_POS_X = 35;
    private static final int BASE_POS_Y = 35;
    private final List<Button> pawns = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        BackgroundSize backgroundSize = new BackgroundSize(100,100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);


        int scale = 45;
        for (int i = 0; i < Board.ROWS_NUM; i++) {
            for (int j = 0; j < BoardRow.COLUMNS_NUM; j++) {
                Figure figure = board.getFigure(i,j);
                if (!(figure instanceof None)) {
                    pawns.add(drawButton(Checkers.BASE_POS_X + (i * scale), Checkers.BASE_POS_Y + (j * scale)));
                }
            }
        }

        GridPane grid = new GridPane();
        grid.setBackground(background);

        pawns.forEach(button -> grid.add(button, 1,1,1,1));

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();


        pawns.get(10).setTranslateY(300);
    }

    private Button drawButton(int posx, int posy) {
        Button button = new Button("click");
        button.setTranslateX(posx);
        button.setTranslateY(posy);
        button.setPrefSize(20,20);
        button.setGraphic(view);
        return button;
    }
}
