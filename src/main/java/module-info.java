module proiect {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.apache.commons.lang3;


    opens proiect to javafx.fxml;
    exports proiect;
}