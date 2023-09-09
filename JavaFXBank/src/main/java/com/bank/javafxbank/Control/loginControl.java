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
        selector.valueProperty().addListener(observable -> setSelector());
        loginButton.setOnAction(event -> {
            if(Model.getInstance().getView().getTypeAccount() == TypeAccount.Client){
                Model.getInstance().client(userField.getText(), passField.getText());
                if (Model.getInstance().getFlagsClient()){onLoginClient();}
                else{error.setText("On Client no Credential");}
            }
            else {
                Model.getInstance().admin(userField.getText(), passField.getText());
                if (Model.getInstance().getFlagsAdmin()){onLoginAdmin();}
                else{error.setText("On Admin no Credential");}
            }
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

    public void setSelector(){
        Model.getInstance().getView().setTypeAccount(selector.getValue());
        if (selector.getValue() == TypeAccount.Admin){
            userLabel.setText("Username");
        }
        else {
            userLabel.setText("Payee Address");
        }
    }
}
