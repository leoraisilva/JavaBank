package com.bank.javafxbank;

import com.bank.javafxbank.Model.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) {
        Model.getInstance().getView().ShowLoginGetWindow();
}

    public static void main(String[]args){launch(args);}

}

