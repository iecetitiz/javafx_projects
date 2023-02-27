package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent actionEvent) { //birden fazla buton bu methodu tetikleyebilir ve her buton
        //farkli bir sekilde calismak isteyebilir onun icin ActionEvent parametresini kullanicam

        //action event burda yalnizca tiklamak degil de suruklemek falan da olabilir

        String butonYazisi = ((Button)(actionEvent.getSource())).getText();
        //olusan bu eventin kaynagi bir buton oldugu icin bu casti gerceklestirebildim
        if(butonYazisi.equals("Love")) {
            welcomeText.setText("Ben Egemi cok seviyooommmm Love!");
            System.out.println("Love butonu tiklandi");
        } else if(butonYazisi.equals("Hello")) {
            welcomeText.setText("Ben Egemi cok seviyooommmm Hello!");
            System.out.println("Hello butonu tiklandi");
        } else  {
            welcomeText.setText("Ben Egemi cok seviyooommmm Fincan!");
            System.out.println("Fincan butonu tiklandi");
        }

        //welcomeText.setText("Ben Egemi cok seviyooommmm!");

    }
}