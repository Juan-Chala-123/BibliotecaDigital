package com.maicol.iterator;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Material> materials = new ArrayList<>();

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public MaterialIterator createMaterialIterator() {
        return new MaterialIterator(materials);
    }
}