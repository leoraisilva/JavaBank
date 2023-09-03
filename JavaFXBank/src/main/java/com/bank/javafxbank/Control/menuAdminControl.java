package com.bank.javafxbank.Control;

import com.bank.javafxbank.Model.Model;
import com.bank.javafxbank.View.AdminView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class menuAdminControl implements Initializable {
    @FXML
    public Button createClientButton;
    @FXML
    public Button clientButton;
    @FXML
    public Button depositClientButton;
    @FXML
    public Button logoutAdminButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    public void addListeners(){
        createClientButton.setOnAction(event -> onCreateClient());
        clientButton.setOnAction(event -> onClient());
        depositClientButton.setOnAction(event -> onDeposit());
    }
    public void onCreateClient(){
        Model.getInstance().getView().getObjectAdminProperty().set(AdminView.CreateAdmin);
    }

    public void onClient(){
        Model.getInstance().getView().getObjectAdminProperty().set(AdminView.ClientAdmin);
    }

    public void onDeposit(){
        Model.getInstance().getView().getObjectAdminProperty().set(AdminView.Deposit);
    }
}
