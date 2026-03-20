/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import model.Library;
import model.Loan;

/**
 *
 * @author JUAN CAMILO
 */

// la clase que se encarga de devolver un material prestado
public class ReturnMaterialCommand implements Command {
    
    // prestamo que se desea cerrar
    private Loan loan;

    
    //constructor
    public ReturnMaterialCommand(Loan loan) {
        this.loan = loan;
    }
    
    // ejecuta la devolucion del material
    @Override 
    public void execute(){
        
        // se cierra el prestamo
        loan.closeLoan();
    }
    
}
