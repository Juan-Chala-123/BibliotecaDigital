/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

/**
 *
 * @author CHALA RAMIREZ
 */
public class StudentLoanStrategy implements ILoanStrategy {

    @Override
    public int loanDays() {
        return 10; // Determina cuantos dias tiene permitido prestar un libro
    }

    @Override
    public double calculateFinde(int days) { // Calcula la multa por los dias de retraso
        double baseFine = LibraryConfig.getInstance().getBaseFine();
        return days * baseFine * 0.5;
    }

    @Override
    public int accessPriority() {
        return 2; // Determina la prioridad
    }
    
}
