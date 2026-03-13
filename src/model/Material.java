/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MERARI URBANO
 */

/**
 * Clase abstracta base para todos los materiales de la biblioteca.
 * Book, Magazine y Thesis heredan de esta clase.
 */

public abstract class Material {
    protected String code;
    protected String title;
    protected String autor;
    protected String category;
    protected boolean available;
    
    /**
     * Constructor base que inicializa todos los atributos comunes.
     * Todo material se crea disponible por defecto.
     */
    public Material(String code, String title, String autor, String category, boolean available) {    
        this.code = code;
        this.title = title;
        this.autor = autor;
        this.category = category;
        this.available = available;
    }

    /**
     * Marca el material como no disponible cuando se presta.
     */
    public void borrow() {
        available = false;
    }
    
    /**
     * Marca el material como disponible cuando se devuelve.
     */
    public void returnMaterial(){
        available = true;
    }
    
    /**
     * Indica si el material puede ser prestado en este momento.
     */
    public boolean isAvailable() {
    return available;
}

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategory() {
        return category;
    }
    
    
}
