package com.example.favoritemoviesapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void init() throws Exception { //burasi benim dosyaya gidip verileri atacagim yer
        super.init();
        FilmData.getInstance().dosyadanFilmleriGetir();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Favorite Movies!");
        stage.setScene(scene);
        stage.show();
        FilmData.getInstance().dosyadanFilmleriGetir();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() throws Exception {
        LocalDate localDate = LocalDate.now(); //direkt new ile localdate olusturamiyorum
        Film f1 = new Film("Gora", "cem yilmaz filmi", localDate);
        FilmData.getInstance().filmEkle(f1); //bu eklemeyi yapmam lazim cunku asagidaki kod listedeki filmleri ekliyor
        FilmData.getInstance().dosyayaFilmleriYaz(); //stop calismadan once bu methodu cagiriyorum
        super.stop(); //uygulama penceresini kapattigim an filmlerin dosyaya yazdirilmasini bekliyorum

    }
}