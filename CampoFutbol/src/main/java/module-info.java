module es.cristiangg.campofutbol {
    requires javafx.controls;
    requires javafx.fxml;
    
    requires java.instrument;
    requires java.persistence;
    requires java.sql;
    
    opens es.cristiangg.campofutbol.entities;
    opens es.cristiangg.campofutbol to javafx.fxml;
    exports es.cristiangg.campofutbol;
}
