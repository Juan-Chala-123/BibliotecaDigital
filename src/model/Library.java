/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import iterator.*;

/**
 *
 * @author MERARI URBANO
 */
public class Library {

    private List<Material> materials;
    private List<Loan> loanHistory;
    private List<User> users;

    public Library() {
        materials = new ArrayList<>();
        loanHistory = new ArrayList<>();
        users = new ArrayList<>();
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

    public void loanMaterial(User user, Material material) {
        Loan loan = new Loan(user, material);

        loan.startLoan();

        loanHistory.add(loan);
    }

    // Agregamos usuarios
    public void addUser(User user) {
        users.add(user);
    }

    // Buscar usuarios por id
    public User findUser(String id) {
        for (User u : users) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    // Listamos los usuarios
    public List<User> getUsers() {
        return users;
    }

    // Listamos el histotial de prestamos
    public List<Loan> getLoanHistory() {
        return loanHistory;
    }
}
