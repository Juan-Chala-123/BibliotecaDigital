/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;
/**
 *
 * @author Asus
 */
public abstract class MaterialCreator {
    //metodo abstracto 
    public abstract Material createMaterial(String code, String title, String author, String category);
}
