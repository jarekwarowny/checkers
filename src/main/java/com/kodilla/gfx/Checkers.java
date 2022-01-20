package com.kodilla.gfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.jar.JarEntry;

public class Checkers extends Application {

    private Image imageback = new Image("file:src/main/resources/WARCABY-scaled.jpg");
    private Image image = new Image("file:src/main/resources/pionek-czarny.pgn");
    ImageView view = new ImageView(image);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100,100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        Button button = new Button("click");
        button.setTranslateX(210);
        button.setTranslateY(33);
        button.setPrefSize(20,20);
        button.setGraphic(view);
        Button button1 = new Button("click");
        button1.setTranslateX(170);
        button1.setTranslateY(33);
        button1.setPrefSize(20,20);
        button1.setGraphic(view);
        Button button2 = new Button("click");
        button2.setTranslateX(125);
        button2.setTranslateY(33);
        button2.setPrefSize(20,20);
        button2.setGraphic(view);
        Button button3 = new Button("click");
        button3.setTranslateX(80);
        button3.setTranslateY(33);
        button3.setPrefSize(20,20);
        button3.setGraphic(view);
        Button button4 = new Button("click");
        button4.setTranslateX(35);
        button4.setTranslateY(33);
        button4.setPrefSize(20,20);
        button4.setGraphic(view);
        Button button5 = new Button("click");
        button5.setTranslateX(255);
        button5.setTranslateY(33);
        button5.setPrefSize(20,20);
        button5.setGraphic(view);
        Button button6 = new Button("click");
        button6.setTranslateX(300);
        button6.setTranslateY(33);
        button6.setPrefSize(20,20);
        button6.setGraphic(view);
        Button button7 = new Button("click");
        button7.setTranslateX(340);
        button7.setTranslateY(33);
        button7.setPrefSize(20,20);
        button7.setGraphic(view);
        Button button8 = new Button("click");
        button8.setTranslateX(167);
        button8.setTranslateY(340);
        button8.setPrefSize(20,20);
        button8.setGraphic(view);
        Button button9 = new Button("click");
        button9.setTranslateX(125);
        button9.setTranslateY(340);
        button9.setPrefSize(20,20);
        button9.setGraphic(view);
        Button button10 = new Button("click");
        button10.setTranslateX(80);
        button10.setTranslateY(340);
        button10.setPrefSize(20,20);
        button10.setGraphic(view);
        Button button11 = new Button("click");
        button11.setTranslateX(35);
        button11.setTranslateY(340);
        button11.setPrefSize(20,20);
        button11.setGraphic(view);
        Button button12 = new Button("click");
        button12.setTranslateX(210);
        button12.setTranslateY(340);
        button12.setPrefSize(20,20);
        button12.setGraphic(view);
        Button button13 = new Button("click");
        button13.setTranslateX(255);
        button13.setTranslateY(340);
        button13.setPrefSize(20,20);
        button13.setGraphic(view);
        Button button14 = new Button("click");
        button14.setTranslateX(300);
        button14.setTranslateY(340);
        button14.setPrefSize(20,20);
        button14.setGraphic(view);
        Button button15 = new Button("click");
        button15.setTranslateX(342);
        button15.setTranslateY(340);
        button15.setPrefSize(20,20);
        button15.setGraphic(view);

        GridPane grid = new GridPane();
        grid.setBackground(background);

        grid.add(button, 1,1,1,1);
        grid.add(button1,1,1,1,1);
        grid.add(button2, 1,1,1,1);
        grid.add(button3, 1,1,1,1);
        grid.add(button4, 1,1,1,1);
        grid.add(button5, 1,1,1,1);
        grid.add(button6, 1,1,1,1);
        grid.add(button7, 1,1,1,1);
        grid.add(button8, 1,1,1,1);
        grid.add(button9, 1,1,1,1);
        grid.add(button10, 1,1,1,1);
        grid.add(button11, 1,1,1,1);
        grid.add(button12, 1,1,1,1);
        grid.add(button13, 1,1,1,1);
        grid.add(button14, 1,1,1,1);
        grid.add(button15, 1,1,1,1);

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
