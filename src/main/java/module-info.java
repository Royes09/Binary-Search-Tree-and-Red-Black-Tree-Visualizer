module com.royes.sda {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.royes.sda to javafx.fxml;
    exports com.royes.sda;
    exports implementations;
    opens implementations to javafx.fxml;
}