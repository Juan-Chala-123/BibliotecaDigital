/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package command;

/**
 *
 * @author JUAN CAMILO
 */

// interfaz Command
public interface Command {
    
    // metodo que todos los comandos deben implementar
    // las clases concretas definiran lo que hace.
    void execute();
    
}
