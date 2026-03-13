/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MERARI URBANO
 */
public class User {
    private String id;
    private String name;
    private String type;
    private LoanStrategy strategy;

    public User(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    
    public void setStrategy(LoanStrategy s) {
        this.strategy = s;
    }

    public LoanStrategy getStrategy() {
        return strategy;
    }

    public String getName() {
        return name;
    }
}
