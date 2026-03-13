/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

/**
 *
 * @author CHALA RAMIREZ
 */
public class ProfessorLoanStrategy implements ILoanStrategy {

    @Override
    public int loanDays() {
        return 20;
    }

    @Override
    public double calculateFinde(int days) {
        double baseFine = LibraryConfig.getInstance().getBaseFine();
        return days * baseFine * 1.0;
    }

    @Override
    public int accessPriority() {
        return 3;
    }
    
}
