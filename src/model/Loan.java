/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author MERARI URBANO
 */
public class Loan {

    private LocalDate loanDate;
    private LocalDate returnDate;
    private String status;

    private User user;
    private Material material;

    public Loan(User user, Material material) {
        this.user = user;
        this.material = material;
    }

    public void startLoan() {

        if(material.isAvailable()) {

            loanDate = LocalDate.now();

            int days = user.getStrategy().loanDays();

            returnDate = loanDate.plusDays(days);

            status = "ACTIVE";

            material.borrow();

            System.out.println("Loan started for " + user.getName());
            System.out.println("Return date: " + returnDate);

        } else {

            System.out.println("Material not available");

        }
    }

    public void closeLoan() {

        status = "RETURNED";

        material.returnMaterial();

        System.out.println("Loan closed");
    }
    
    
}
