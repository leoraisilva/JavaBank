package com.bank.javafxbank.Model;

import com.bank.javafxbank.View.ViewFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory view;
    private final Database database;
    private Clients client;
    private boolean ClientFlagAccount;
    private boolean AdminFlagAccount;
    private TypeAccount typeAccount = TypeAccount.Client;

    public Model() {
        this.view = new ViewFactory();
        this.database = new Database();
        this.AdminFlagAccount = false;
        this.ClientFlagAccount = false;
        this.client = new Clients("", "", "", null, null, null);
    }

    public static synchronized Model getInstance() {
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public Database getDatabase() {
        return database;
    }
    public boolean getFlagsAdmin () {return AdminFlagAccount;}
    public boolean getFlagsClient(){
        return ClientFlagAccount;
    }

    public void setAdminFlagAccount() {AdminFlagAccount = false;}

    public void setClientFlagAccount() {
        ClientFlagAccount = false;
    }

    public ViewFactory getView() {
        return this.view;
    }

    public void client(String user, String pass) {
        AccountChecking accountChecking;
        AccountSaving accountSaving;
        ResultSet resultset = null;
        try{
            resultset = database.getValueClient(user, pass);
            if(resultset.isBeforeFirst()){
                this.client.getFirstNameProperty().set(resultset.getString("FirstName"));
                this.client.getLastNameProperty().set(resultset.getString("LastName"));
                this.client.getPayeeAddressProperty().set(resultset.getString("PayeeAddress"));
                String[] partDate = resultset.getString("Date").split("-");
                LocalDate Date = LocalDate.of(Integer.parseInt(partDate[0]), Integer.parseInt(partDate[1]), Integer.parseInt(partDate[2]));
                this.client.getDateProperty().set(Date);
                accountChecking = null;
                accountSaving = null;
                ClientFlagAccount = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void admin(String user, String pass){
        ResultSet resultSet = null;
        try {
            resultSet = database.getValueAdmin(user, pass);
            if (resultSet.isBeforeFirst()) {
                AdminFlagAccount = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
