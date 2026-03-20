/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import model.Library;
import iterator.MaterialIterator;
import model.Material;

/**
 *
 * @author JUAN CAMILO
 */

// esta clase nos permite listar todos los materiales registrados
public class ListMaterialsCommand implements Command{
    
    // Biblioteca que contiene los materiales
    private Library library;

    public ListMaterialsCommand(Library library) {
        this.library = library;
    }
    
    // ejecuta el listado de materiales
    @Override
    public void execute() {

        // Se obtiene el iterador de materiales
        MaterialIterator iterator = library.createMaterialIterator();

         // Se recorre la colección usando Iterator
        while (iterator.hasNext()) {

            Material material = iterator.next();

            System.out.println(material);
        }
    }
    
}
