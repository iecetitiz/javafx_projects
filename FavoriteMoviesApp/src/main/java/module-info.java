module com.example.favoritemoviesapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.favoritemoviesapp to javafx.fxml;
    exports com.example.favoritemoviesapp;
}