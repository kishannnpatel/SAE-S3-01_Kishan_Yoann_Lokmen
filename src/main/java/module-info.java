module com.example.sae_dev_kishan_yoann_lokmen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.sae_dev_kishan_yoann_lokmen to javafx.fxml;
    exports com.example.sae_dev_kishan_yoann_lokmen;
}