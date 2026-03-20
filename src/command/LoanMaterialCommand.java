/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import model.Library;
import model.Material;
import model.User;

/**
 *
 * @author JUAN CAMILO
 */

// esta es la clase que se encarga de hacer un prestamo de un material
public class LoanMaterialCommand implements Command {
    
    // Biblioteca de donde se realiza el prestamo
    private Library library;
    
    // Usuario que solicito el prestamo
    private User user;
    
    // Material que se va prestar
    private Material material;

    
    // constructor
    public LoanMaterialCommand(Library library, User user, Material material) {
        this.library = library;
        this.user = user;
        this.material = material;
    }

    // se ejecuta la accion del prestamo
    @Override
    public void execute(){
        
        // Se llama al metodo de la biblioteca
        library.loanMaterial(user, material);
    }
}
