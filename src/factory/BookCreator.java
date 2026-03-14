/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;
import model.Book;
import model.Material;
import factory.MaterialCreator;
/**
 *
 * @author Asus
 */
public class BookCreator extends MaterialCreator{
     @Override
    public Material createMaterial(String code, String title, String author, String category) {
        return new Book(code, title, author, category); // Crea un libro
    }
}
