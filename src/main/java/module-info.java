module com.example.currencyconverter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.currencyconverter to javafx.fxml;
    exports com.example.currencyconverter;
}