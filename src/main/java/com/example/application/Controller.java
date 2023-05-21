package com.example.application;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import model.entities.Pessoa;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // CALCULADORA
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

    // ComboBox
    @FXML
    private ComboBox<Pessoa> comboBoxPessoa;

    @FXML
    private Label labelResultadoPessoa;

    @FXML
    private void onComboBoxPessoaAction() { // Quando o item do combobox for selecionado, os atributos do objeto terão saída visual no label abaixo
        Pessoa pessoa = comboBoxPessoa.getSelectionModel().getSelectedItem(); // Pega o item que foi selecionado no Combobox
        labelResultadoPessoa.setText(pessoa.toString());
    }

    @FXML
    private Button btTodos;

    @FXML
    public void onBtTodosAction() { // Mostra todos os objetos em um label quando acionado o botão
        StringBuilder todos = new StringBuilder();
        for (Pessoa pessoa : comboBoxPessoa.getItems()) {
            assert false;
            String nomeFormatado = String.format("Nome: %-" + 10 + "s", pessoa.getNome());
            String emailFormatado = String.format("Email: %s", pessoa.getEmail());

            todos.append(nomeFormatado).append(emailFormatado).append("\n");
        }
        labelResultadoPessoa.setText(todos.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Calculadora
        Constraints.setTextFieldDouble(txtNumero1);
        Constraints.setTextFieldDouble(txtNumero2);
        Constraints.setTextFieldMaxLength(txtNumero1, 12);
        Constraints.setTextFieldMaxLength(txtNumero2, 12);

        // ComboBox (List box)
        List<Pessoa> list = new ArrayList<>();
        list.add(new Pessoa(1, "Maria", "maria@gmail.com"));
        list.add(new Pessoa(2, "Alex", "alex@gmail.com"));
        list.add(new Pessoa(3, "Bob", "bob@gmail.com"));
        list.add(new Pessoa(4, "Ana", "ana@gmail.com"));

        ObservableList<Pessoa> obsList = FXCollections.observableArrayList(list); // Implementa a interação entre um atributo (ComboBox nesse caso) e um Objeto

        comboBoxPessoa.setItems(obsList); // Carrega os elementos no combobox

        Callback<ListView<Pessoa>, ListCell<Pessoa>> factory = lv -> new ListCell<Pessoa>() { // Personaliza como cada Objeto irá aparecer visualmente no Combobox
            @Override
            protected void updateItem(Pessoa item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        };
        comboBoxPessoa.setCellFactory(factory);
        comboBoxPessoa.setButtonCell(factory.call(null));
    }


}