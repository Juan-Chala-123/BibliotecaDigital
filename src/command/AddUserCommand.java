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

public class AddUserCommand implements Command {
    
    private Library library;
    private User user;

    public AddUserCommand(Library library, User user) {
        this.library = library;
        this.user = user;
    }

    @Override
    public void execute() {
        if (library.findUser(user.getId()) != null) {
            System.out.println("User with ID " + user.getId() + " already exists.");
            return;
        }
        library.addUser(user);
        System.out.println("User '" + user.getName() + "' registered successfully.");
    }
}
