/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import strategy.ILoanStrategy;

/**
 *
 * @author MERARI URBANO
 */
public class User {
    private String id;
    private String name;
    private String type;
    private ILoanStrategy strategy;
    
    /*
    *Constructor
    */
    public User(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    
    public void setStrategy(ILoanStrategy s) {
        this.strategy = s;
    }

    public ILoanStrategy getStrategy() {
        return strategy;
    }

    public String getName() {
        return name;
    }
    
}
