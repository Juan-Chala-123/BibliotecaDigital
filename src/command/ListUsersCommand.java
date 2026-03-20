/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import model.Library;
import model.User;

/**
 *
 * @author BibliotecaDigital
 */

public class ListUsersCommand implements Command {
    
    private Library library;

    public ListUsersCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        if (library.getUsers().isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        System.out.println("\n=== Registered Users ===");
        for (User user : library.getUsers()) {
            System.out.println("ID: " + user.getId() + " | Name: " + user.getName() + " | Type: " + user.getType());
        }
    }
}
