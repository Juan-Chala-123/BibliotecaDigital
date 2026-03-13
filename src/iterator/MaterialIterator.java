/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maicol.iterator;
import java.util.List;
import model.Material;
/**
 *
 * @author Maicol
 */

public class MaterialIterator implements Iterator<Material> {

    private List<Material> materials;
    private int index = 0;

    public MaterialIterator(List<Material> materials) {
        this.materials = materials;
    }

    @Override
    public boolean hasNext() {
        return index < materials.size();
    }

    @Override
    public Material next() {
        return materials.get(index++);
    }
}
