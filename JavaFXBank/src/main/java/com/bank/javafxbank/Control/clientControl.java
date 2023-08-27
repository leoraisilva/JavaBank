package com.bank.javafxbank.Control;

import com.bank.javafxbank.Model.Model;
import com.bank.javafxbank.View.ClientView;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class clientControl implements Initializable {
    @FXML
    public BorderPane clientPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Model.getInstance().getView().getObjectProperty().addListener((Observable, oldValue, newValue) ->{
            switch (newValue){
                case Dashboard -> clientPane.setCenter(Model.getInstance().getView().getDashboard());
                case Transaction -> clientPane.setCenter(Model.getInstance().getView().getTransaction());
                case Account -> clientPane.setCenter(Model.getInstance().getView().getAccount());
            }
        });
    }
}
