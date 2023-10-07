module com.example.grapheditor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens grapher to javafx.fxml;
    exports grapher;
}