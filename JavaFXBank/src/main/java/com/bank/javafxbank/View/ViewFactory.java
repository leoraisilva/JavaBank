package com.bank.javafxbank.View;

import com.bank.javafxbank.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private AnchorPane DashboardView;

    public ViewFactory(){}

    public AnchorPane getDashboard() {
        if(DashboardView==null) {
            try {
                DashboardView = new FXMLLoader(ViewFactory.class.getResource("ClientFXML/dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  DashboardView;
    }

    public void getScene(FXMLLoader loader){
        Scene scene =  null;
        try {
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("JavaFXBank");

        stage.show();
    }

    public void ShowLoginGetWindow(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("login.fxml"));
        getScene(loader);
    }
}
