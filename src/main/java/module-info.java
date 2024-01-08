module com.example.merchlogistics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.merchlogistics to javafx.fxml;
    exports com.example.merchlogistics;
    exports com.example.merchlogistics.Controllers;
    exports com.example.merchlogistics.Enums;
    opens com.example.merchlogistics.Controllers to javafx.fxml;
    exports com.example.merchlogistics.Workers;
    opens com.example.merchlogistics.Workers to javafx.fxml;
}