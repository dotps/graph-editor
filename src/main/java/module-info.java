module com.example.grapheditor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.grapheditor to javafx.fxml;
    exports com.example.grapheditor;
}