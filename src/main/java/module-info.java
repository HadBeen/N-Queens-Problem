module com.example.nqueen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.nqueen to javafx.fxml;
    exports com.example.nqueen;
}