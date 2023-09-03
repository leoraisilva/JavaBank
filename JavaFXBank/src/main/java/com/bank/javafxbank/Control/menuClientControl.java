package com.bank.javafxbank.Control;

import com.bank.javafxbank.Model.Model;
import com.bank.javafxbank.View.ClientView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class menuClientControl implements Initializable {
    @FXML
    public Button dashboardButton;
    @FXML
    public Button transactionButton;
    @FXML
    public Button accountButton;
    @FXML
    public Button profileButton;
    @FXML
    public Button logoutButton;
    @FXML
    public Button reportButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    public void addListeners(){
        dashboardButton.setOnAction(event ->{onDashboard();});
        transactionButton.setOnAction(event ->{onTransaction();});
        accountButton.setOnAction(event ->{onAccount();});
    }
    public void onDashboard(){
        Model.getInstance().getView().getObjectClientProperty().set(ClientView.Dashboard);
    }
    public void onTransaction(){
        Model.getInstance().getView().getObjectClientProperty().set(ClientView.Transaction);
    }
    public void onAccount(){
        Model.getInstance().getView().getObjectClientProperty().set(ClientView.Account);
    }
}
