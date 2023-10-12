module com.example.grapheditor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens grapher to javafx.fxml;
    exports grapher;
}