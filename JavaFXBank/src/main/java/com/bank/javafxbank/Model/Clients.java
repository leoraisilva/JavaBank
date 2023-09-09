package com.bank.javafxbank.Model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Clients {
    private StringProperty FirstName;
    private StringProperty LastName;
    private StringProperty PayeeAddress;
    private ObjectProperty<AccountChecking> accountChecking;
    private ObjectProperty<AccountSaving> accountSaving;
    private ObjectProperty<LocalDate> Date;

    public Clients(String FirstName, String LastName, String PayeeAddress, AccountChecking accountChecking, AccountSaving accountSaving, LocalDate Date){
        this.FirstName = new SimpleStringProperty(this,"FirstName", FirstName);
        this.LastName = new SimpleStringProperty(this,"LastName", LastName);
        this.PayeeAddress = new SimpleStringProperty(this,"PayeeAddress", PayeeAddress);
        this.accountChecking = new SimpleObjectProperty<AccountChecking>(this,"AccountChecking", accountChecking);
        this.accountSaving = new SimpleObjectProperty<AccountSaving>(this,"AccountSaving", accountSaving);
        this.Date = new SimpleObjectProperty<LocalDate>(this,"LocalDate", Date);
    }

    public StringProperty getFirstNameProperty() {return FirstName;}

    public StringProperty getLastNameProperty() {return LastName;}

    public StringProperty getPayeeAddressProperty() {return PayeeAddress;}

    public ObjectProperty<AccountChecking> getAccountCheckingProperty() {return accountChecking;}

    public ObjectProperty<AccountSaving> getAccountSavingProperty() {return accountSaving;}

    public ObjectProperty<LocalDate> getDateProperty() {return Date;}
}
