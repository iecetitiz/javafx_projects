package com.example.girisekrani;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

public class HelloController {
    @FXML
    public void initialize() { //bu method daha hicbir sey baslamadan devreye girer
        //ben de butonlarimi en basinda tiklanamaz bir sekilde olusturuyorum

        //butonlara yaptigim gibi text fieldlara da bir sey yazildiginda onlari tetikletip islem yaptirabilirim

        btnMerhaba.setDisable(true);
        btnHoscakal.setDisable(true);
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    private Button btnHoscakal;

    @FXML
    private Button btnIsmiTemizle;

    @FXML
    private CheckBox checkbox;

    @FXML
    private Button btnMerhaba;

    @FXML
    private TextField txtName;



    @FXML
    private Button buton;

    @FXML
    private TextField email;

    @FXML
    private PasswordField sifre;

    @FXML
    private Label sonuc;

    @FXML
    private Button helpButton;

    @FXML
    public void girisyap(ActionEvent actionEvent) {
        if(email.getText().equals("i.ecetitiz@gmail.com") && sifre.getText().equals("1234")) {
            sonuc.setText("Basarili Giris");
        } else {
            sonuc.setText("Email/Sifre Hatali");
        }
        System.out.println("ecemmmm ben ece");
    }

    @FXML
    void yardimiste(ActionEvent actionEvent) {
        System.out.println(actionEvent.getSource());
    }

    @FXML
    void keyReleased(KeyEvent event) {
        System.out.println("key released!!!");
        String name = txtName.getText().trim();
        boolean butonlariDisableEt = name.isEmpty() || name.trim().isEmpty();
        btnMerhaba.setDisable(butonlariDisableEt);
        btnHoscakal.setDisable(butonlariDisableEt);
    }

    @FXML
    void chechboxsecimi(ActionEvent event) {
        System.out.println("seciliyseee");
    }

    @FXML
    void ismiTemizle(ActionEvent event) {

    }

    @FXML
    void harfSayisiniVer(ActionEvent event) {

    }


    @FXML
    void doSomething(ActionEvent actionEvent) {
        String name = txtName.getText();
        if(actionEvent.getSource().equals(btnMerhaba)) {
            System.out.println("Merhaba " + name);
        } else if(actionEvent.getSource().equals(btnHoscakal)) {
            System.out.println("Hoscakal " + name);
        }
    }
}