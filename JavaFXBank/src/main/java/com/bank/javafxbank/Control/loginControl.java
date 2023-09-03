package com.bank.javafxbank.Control;

import com.bank.javafxbank.Model.Model;
import com.bank.javafxbank.Model.TypeAccount;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class loginControl implements Initializable {
    @FXML
    public ChoiceBox<TypeAccount>  selector;
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
        selector.setItems(FXCollections.observableArrayList(TypeAccount.Client, TypeAccount.Admin));
        selector.setValue(Model.getInstance().getView().getTypeAccount());
        selector.valueProperty().addListener(observable -> Model.getInstance().getView().setTypeAccount(selector.getValue()));
        loginButton.setOnAction(event -> {
            if(Model.getInstance().getView().getTypeAccount() == TypeAccount.Client){onLoginClient();}
            else {onLoginAdmin();}
        });
    }
    private void onLoginClient(){
        Stage stage = (Stage) error.getScene().getWindow();
        Model.getInstance().getView().ShowClientGetWindow();
        Model.getInstance().getView().getClose(stage);
    }
    private void onLoginAdmin(){
        Stage stage = (Stage) error.getScene().getWindow();
        Model.getInstance().getView().ShowAdminGetWindow();
        Model.getInstance().getView().getClose(stage);
    }
}
