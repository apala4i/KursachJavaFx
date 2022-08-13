module com.example.kursachjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires ejml;


    opens com.example.kursachjavafx to javafx.fxml;
    exports com.example.kursachjavafx;
    exports com.example.kursachjavafx.command;
    opens com.example.kursachjavafx.command to javafx.fxml;
    exports com.example.kursachjavafx.DrawingCanvas;
    opens com.example.kursachjavafx.DrawingCanvas to javafx.fxml;
    exports com.example.kursachjavafx.command.Figure;
    opens com.example.kursachjavafx.command.Figure to javafx.fxml;
    exports com.example.kursachjavafx.command.Camera;
    opens com.example.kursachjavafx.command.Camera to javafx.fxml;
}