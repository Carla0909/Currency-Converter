package com.example.currencyconverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ConversorController {

    @FXML
    private RadioMenuItem eurToUsd, eurToGbp, usdToEur, usdToGbp, gbpToEur, gbpToUsd;
    @FXML
    private Button btnBorrar;
    @FXML
    private Label resultLabel;
    @FXML
    private MenuBar menuDivisas;
    @FXML
    private TextField inputField;
    private double valorConversion;
    @FXML
    private ToggleGroup grupoActual = new ToggleGroup();

    public void setValorConversion(double valorConversion) {
        this.valorConversion = valorConversion;
    }

    @FXML
    public void Actionborrar(ActionEvent event) {
        inputField.clear();
        resultLabel.setText("");
    }

    @FXML
    public void initialize() {
        // Tasa de conversión por defecto
        valorConversion = 1.07;

        eurToUsd.setOnAction(event -> setValorConversion(1.07));  // EUR a USD
        eurToGbp.setOnAction(event -> setValorConversion(0.87));  // EUR a GBP
        usdToEur.setOnAction(event -> setValorConversion(1 / 1.07));  // USD a EUR
        usdToGbp.setOnAction(event -> setValorConversion(0.82));  // USD a GBP
        gbpToEur.setOnAction(event -> setValorConversion(1 / 0.87));  // GBP a EUR
        gbpToUsd.setOnAction(event -> setValorConversion(1 / 0.82));  // GBP a USD


       //Listener
        inputField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                double num = Double.parseDouble(newValue);
                double resultado = num * valorConversion;
                resultLabel.setText(String.format("%.2f", num) + " = " + String.format("%.2f", resultado));
            } catch (NumberFormatException e) {
                resultLabel.setText("Resultado conversión");
            }
        });
    }
}
