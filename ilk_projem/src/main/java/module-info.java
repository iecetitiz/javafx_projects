module com.example.ilk_projem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ilk_projem to javafx.fxml;
    exports com.example.ilk_projem;
}