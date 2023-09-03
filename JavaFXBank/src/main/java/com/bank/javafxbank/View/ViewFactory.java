package com.bank.javafxbank.View;

import com.bank.javafxbank.Main;
import com.bank.javafxbank.Model.TypeAccount;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private TypeAccount typeAccount;
    private final ObjectProperty<TypeAccount> typeAccountObjectProperty;
    /* Cliente */
    private final ObjectProperty<ClientView> objectClientProperty;
    private AnchorPane DashboardView;
    private AnchorPane TransactionView;
    private AnchorPane AccountView;
    /* Client */
    /*Admin*/
    private final ObjectProperty<AdminView> objectAdminProperty;
    private AnchorPane ClientAdminView;
    private AnchorPane CreateAdminView;
    private AnchorPane DepositView;
    /* Admin */
    /* Construct */
    public ViewFactory(){
        this.typeAccount = TypeAccount.Client;
        this.typeAccountObjectProperty = new SimpleObjectProperty<TypeAccount>();
        this.objectClientProperty = new SimpleObjectProperty<ClientView>();
        this.objectAdminProperty = new SimpleObjectProperty<AdminView>();
    }

    /* Construct */

    public AnchorPane getClientAdmin() {
        if(ClientAdminView==null) {
            try {
                ClientAdminView = new FXMLLoader(Main.class.getResource("AdminFXML/clientAdmin.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  ClientAdminView;
    }

    public AnchorPane getCreateAdmin() {
        if(CreateAdminView==null) {
            try {
                CreateAdminView = new FXMLLoader(Main.class.getResource("AdminFXML/createAdmin.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  CreateAdminView;
    }

    public AnchorPane getDeposit() {
        if(DepositView==null) {
            try {
                DepositView = new FXMLLoader(Main.class.getResource("AdminFXML/depositAdmin.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  DepositView;
    }
    /*Client */


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

    public ObjectProperty<TypeAccount> typeAccountObjectPropertyProperty() {
        return typeAccountObjectProperty;
    }

    public TypeAccount getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(TypeAccount typeAccount) {
        this.typeAccount = typeAccount;
    }

    public ObjectProperty<ClientView> getObjectClientProperty() {
        return objectClientProperty;
    }
    /* Cliente */
    /* Admin */
    public ObjectProperty<AdminView> getObjectAdminProperty() {
        return objectAdminProperty;
    }
    /* Admin */

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

    public void ShowAdminGetWindow(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/admin.fxml"));
        getScene(loader);
    }
}
