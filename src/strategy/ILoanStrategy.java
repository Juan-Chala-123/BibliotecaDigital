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
    int loanDays(); // Devuelve el número de días que un usuario puede tomar prestado un libro
    double calculateFinde(int days); // Calcula la multa por retraso en base a los días que se pasó del plazo
    int accessPriority(); // Devuelve la prioridad de acceso del usuario (mayor número = mayor prioridad)
}
