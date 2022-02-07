package com.kodilla.gfx;

import com.kodilla.checkers.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Checkers extends Application {

    private Image imageback = new Image("file:src/main/resources/plansz1.png");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        BackgroundSize backgroundSize = new BackgroundSize (0,0,true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        for (int n = 0; n < 8; n++) {
            grid.getRowConstraints().add(new RowConstraints(100));
            grid.getColumnConstraints().add(new ColumnConstraints(100));
        }
        grid.setBackground(background);

        Board board = new Board();
        GameController gameController = new GameController(board,grid);
        gameController.display();

        grid.setOnMouseClicked(e-> {
            int x = (int)e.getX()/100;
            int y = (int)e.getY()/100;
            gameController.doClick(x,y);
        });

        Scene scene = new Scene(grid, 800, 800);
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
