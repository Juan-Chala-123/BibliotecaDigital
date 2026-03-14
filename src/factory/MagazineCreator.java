/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;
import model.Magazine;
import model.Material;
import factory.MaterialCreator;
/**
 *
 * @author Asus
 */
public class MagazineCreator extends MaterialCreator {
     @Override
    public Material createMaterial(String code, String title, String author, String category) {
        return new Magazine(code, title, author, category); // Crea una revista
    }
}
