package com.bank.javafxbank.View;

import com.bank.javafxbank.Main;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private final ObjectProperty<ClientView> objectProperty;
    private AnchorPane DashboardView;
    private AnchorPane TransactionView;
    private AnchorPane AccountView;


    public ViewFactory(){
        objectProperty = new SimpleObjectProperty<ClientView>();
    }

    public AnchorPane getDashboard() {
        if(DashboardView==null) {
            try {
                DashboardView = new FXMLLoader(Main.class.getResource("ClientFXML/dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  DashboardView;
    }

    public AnchorPane getTransaction() {
        if(TransactionView==null) {
            try {
                TransactionView = new FXMLLoader(Main.class.getResource("ClientFXML/transaction.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  TransactionView;
    }

    public AnchorPane getAccount() {
        if(AccountView==null) {
            try {
                AccountView = new FXMLLoader(Main.class.getResource("ClientFXML/account.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  AccountView;
    }

    public ObjectProperty<ClientView> getObjectProperty() {
        return objectProperty;
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
        stage.getIcons().add(new Image(String.valueOf(Main.class.getResource("imagem/icon.png"))));
        stage.setResizable(false);
        stage.setTitle("JavaFXBank");
        stage.show();
    }

    public void getClose(Stage stage){
        stage.close();
    }

    public void ShowLoginGetWindow(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("login.fxml"));
        getScene(loader);
    }

    public void ShowClientGetWindow(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("ClientFXML/client.fxml"));
        getScene(loader);
    }

}
