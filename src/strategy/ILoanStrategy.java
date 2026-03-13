/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package strategy;

/**
 *
 * @author CHALA RAMIREZ
 */
public interface ILoanStrategy {
    int loanDays();
    double calculateFinde(int days);
    int accessPriority();
}
