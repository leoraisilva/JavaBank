package com.bank.javafxbank.Control;

import com.bank.javafxbank.Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class adminControl implements Initializable {
    @FXML
    public BorderPane adminPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getView().getObjectAdminProperty().addListener((observable, oldVal, newVal)->{
            switch (newVal){
                case ClientAdmin -> adminPane.setCenter(Model.getInstance().getView().getClientAdmin());
                case CreateAdmin -> adminPane.setCenter(Model.getInstance().getView().getCreateAdmin());
                case Deposit -> adminPane.setCenter(Model.getInstance().getView().getDeposit());
            }
        });
    }
}
