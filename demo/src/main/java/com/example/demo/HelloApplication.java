package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void init() throws Exception {
        super.init();
    }
  @Override
    public void stop() throws Exception {
        super.stop();
    }
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml")); //goruntu dosyalarimi getiriyor
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello Dear!");
        stage.setScene(scene);
        //stage.setResizable(false); artik stageim buyumicek ve kuculmicek

        stage.show(); //bunu demedigimde pencere ekranda gorunmeyecek
    }

    public static void main(String[] args) {
        launch();
    }
}