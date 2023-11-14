module com.mycompany.portfolio {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.portfolio to javafx.fxml;
    exports com.mycompany.portfolio;
}
