package gui.util;

import javafx.scene.control.TextField;

public class Constraints {

    // Verifica se o valor inserido são apenas digitos, se sim, retorna ao valor anterior
    public static void setTextFieldInteger(TextField txt) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*")) {
                txt.setText(oldValue);
            }
        });
    }

    // Verifica se o valor inserido não ultrapassa o limite de caracteres estabelecido
    public static void setTextFieldMaxLength(TextField txt, int max) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && newValue.length() > max) {
                txt.setText(oldValue);
            }
        });
    }

    // Verifica se o valor inserido são apenas digitos (método para números flutuantes)
    public static void setTextFieldDouble(TextField txt) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*(\\.\\d*)?")) {
                txt.setText(oldValue);
            }
        });
    }



}
