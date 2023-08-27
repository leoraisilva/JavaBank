package com.bank.javafxbank.Control;

import com.bank.javafxbank.Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class loginControl implements Initializable {
    @FXML
    public ChoiceBox  selector;
    @FXML
    public Label userLabel;
    @FXML
    public TextField userField;
    @FXML
    public PasswordField passField;
    @FXML
    public Button loginButton;
    @FXML
    public Label error;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(event -> {
            Stage stage = (Stage) error.getScene().getWindow();
            Model.getInstance().getView().ShowClientGetWindow();
            Model.getInstance().getView().getClose(stage);
        });
    }
}
