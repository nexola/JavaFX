package com.example.application;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField txtNumero1;

    @FXML
    private TextField txtNumero2;

    @FXML
    private Label labelResultado;

    @FXML
    private Button btSoma;

    @FXML
    public void onBtSomaAction() {
        try {
            double numero1 = Double.parseDouble(txtNumero1.getText());
            double numero2 = Double.parseDouble(txtNumero2.getText());
            labelResultado.setText(String.valueOf(numero1 + numero2));
        } catch (NumberFormatException e) {
            Alerts.showAlert("Erro", "Erro de inserção", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldDouble(txtNumero1);
        Constraints.setTextFieldDouble(txtNumero2);
        Constraints.setTextFieldMaxLength(txtNumero1, 12);
        Constraints.setTextFieldMaxLength(txtNumero2, 12);
    }
}