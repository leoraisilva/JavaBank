package com.bank.javafxbank.Model;
import java.sql.*;
public class Database {
    private Connection connection;
    private Statement statement;

    public Database(){
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/leyto/OneDrive/Documentos/ProjetoTest/Bank/JavaFXBank/src/main/resources/com/bank/javafxbank/JavaFXBank.db");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet getValueClient(String user, String pass){
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='" + user + "' AND Password='" + pass + "';");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet getValueAdmin(String user, String pass){
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Admins WHERE Username='" + user + "' AND Password='" + pass + "';");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return resultSet;
    }
}
