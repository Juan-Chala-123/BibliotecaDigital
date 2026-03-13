/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MERARI URBANO
 */
public class Library {

    private List<Material> materials;
    private List<Loan> loanHistory;

    public Library() {
        materials = new ArrayList<>();
        loanHistory = new ArrayList<>();
    }

    // Agregamos material a la biblioteca
    public void addMaterial(Material m) {
        materials.add(m);
    }

    // Buscamos el material por codigo
    public Material findMaterial(String code) {
        for (Material m : materials) {
            if (m.getCode().equals(code)) {
                return m;
            }
        }
        return null;
    }

    // Obtenemos todos los materiales
    public List<Material> getMaterials() {
        return materials;
    }

    // Creamos iterador de materiales
    public MaterialIterator createMaterialIterator() {
        return new MaterialIterator(materials);
    }

    // Creamos iterador del historial de préstamos
    public LoanHistoryIterator createLoanIterator() {
        return new LoanHistoryIterator(loanHistory);
    }

    // Registramos prestamo en el historial
    public void addLoan(Loan loan) {
        loanHistory.add(loan);
    }
}
