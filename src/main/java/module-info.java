module com.example.kursachjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires ejml;


    opens com.example.kursachjavafx to javafx.fxml;
    exports com.example.kursachjavafx;
}