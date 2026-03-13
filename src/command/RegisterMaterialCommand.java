/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import model.Library;
import model.Material;

/**
 *
 * @author JUAN CAMILO
 */

// se encarga de registrar un nuevo material en la biblioteca
public class RegisterMaterialCommand implements Command{
    
    // Referencia a la biblioteca (donde se guardan los materiales)
    private Library library;
    
    // Material que se desea registrar
    private Material material;

    
    // constructotr, que resibe la biblioteca y el material para registrar
    public RegisterMaterialCommand(Library library, Material material) {
        this.library = library;
        this.material = material;
    }
    
    // metodo obligatorio del patron donde se ejecute la accion real
    @Override
    public void execute() {
        // Se da la acción a la clase Library
        library.addMaterial(material);

        System.out.println("Material registered successfully.");
    }
    
}
