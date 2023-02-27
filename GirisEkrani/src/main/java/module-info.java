module com.example.girisekrani {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.girisekrani to javafx.fxml;
    exports com.example.girisekrani;
}