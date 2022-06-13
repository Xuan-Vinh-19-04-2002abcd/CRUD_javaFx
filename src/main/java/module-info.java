module com.example.pnstudentmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pnstudentmanagement to javafx.fxml;
    exports com.example.pnstudentmanagement;
}