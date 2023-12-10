module quynh {
    requires javafx.controls;
    requires javafx.fxml;

    opens quynh to javafx.fxml;
    exports quynh;
}
