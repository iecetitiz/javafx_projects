package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application { //javafx oldugunu bu extends satiri soyluyor
    @Override
    public void init() throws Exception{ //
        System.out.println("init methodu tetiklendi");
        super.init();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400); // 320'ye 240

        stage.setTitle("Login App Hallihalloo");
        stage.setScene(scene);
        stage.setResizable(false); //artik acilan pencerem buyuyup kuculemez
        stage.show(); //bunu yazmasam pencere gorunmez
    }

    public void stop() throws Exception{ //uygulam Kapatilmadan hemen once tetikleniyor
        System.out.println("stop methodu tetiklendi");
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}