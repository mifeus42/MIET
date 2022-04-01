package com.example.interpreter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Button button = new Button();
    private TextArea textArea = new TextArea();
    private VBox vbox = new VBox();

    @Override
    public void start(Stage stage) throws IOException {

        button.setText("Корректировать");
        textArea.setPromptText("Введите текст");
        textArea.setFocusTraversable(false);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setSpacing(30);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(textArea, button);

        MainCorrector mainCorrector = new MainCorrector();

        button.setOnAction(e -> {
            textArea.setText(mainCorrector.correct(textArea.getText()));
        });


        String test = new String("1)МультиПробел    проверка\n2)МультиПереносСтроки\n\nПроверка\n3)ЛишнийПробел ( раз ) , два .\n4)Кавычки \"q\"\n5)Дефис - Тире\n\t\t6)Табуляции\t\tтабуляции");
        System.out.println(test);

        stage.setTitle("Interpreter");
        stage.setScene(new Scene(vbox, 600, 600));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}