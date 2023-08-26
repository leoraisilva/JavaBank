package com.bank.javafxbank.Model;

import com.bank.javafxbank.View.ViewFactory;

public class Model {
    private static Model model;
    private final ViewFactory view;

    public Model(){
        this.view = new ViewFactory();
    }

    public static synchronized Model getInstance() {
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getView() {
        return this.view;
    }
}
