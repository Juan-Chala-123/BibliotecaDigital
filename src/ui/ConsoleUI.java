package ui;

import command.*;
import factory.*;
import iterator.*;
import model.*;
import observer.*;
import singleton.*;
import strategy.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private Library library;
    private LibraryConfig config;
    private LibraryEventPublisher publisher;
    private ILoanStrategy currentStrategy;
    private Scanner scanner;
    private List<UserObserver> userObservers;

    public ConsoleUI() {
        this.library = new Library();
        this.config = LibraryConfig.getInstance();
        this.publisher = new LibraryEventPublisher();
        this.scanner = new Scanner(System.in);
        this.currentStrategy = new StudentLoanStrategy();
        this.userObservers = new ArrayList<>();

        publisher.addObserver(new AdminObserver("Admin"));
        publisher.addObserver(new AuditObserver());
    }

    public void run() {
        System.out.println("=== " + config.getLibraryName() + " ===");
        System.out.println("Max loans per user: " + config.getMaxLoans());
        System.out.println("Base fine: $" + config.getBaseFine());
        System.out.println();

        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Register Material");
            System.out.println("2. List Materials");
            System.out.println("3. Loan Material");
            System.out.println("4. Return Material");
            System.out.println("5. Delete Material");
            System.out.println("6. Check Availability");
            System.out.println("7. View Loan History");
            System.out.println("8. Change Loan Strategy");
            System.out.println("9. Show Configuration");
            System.out.println("--- User Management ---");
            System.out.println("10. Register User");
            System.out.println("11. List Users");
            System.out.println("12. View Loaned Materials");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerMaterial();
                    break;
                case 2:
                    listMaterials();
                    break;
                case 3:
                    loanMaterial();
                    break;
                case 4:
                    returnMaterial();
                    break;
                case 5:
                    deleteMaterial();
                    break;
                case 6:
                    checkAvailability();
                    break;
                case 7:
                    viewLoanHistory();
                    break;
                case 8:
                    changeStrategy();
                    break;
                case 9:
                    showConfig();
                    break;
                case 10:
                    registerUser();
                    break;
                case 11:
                    listUsers();
                    break;
                case 12:
                    viewLoanedMaterials();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void registerMaterial() {
        System.out.println("\n--- Register Material ---");
        System.out.println("Type (1=Book, 2=Magazine, 3=Thesis): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Code: ");
        String code = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();

        MaterialCreator creator;
        switch (type) {
            case 1: creator = new BookCreator(); break;
            case 2: creator = new MagazineCreator(); break;
            case 3: creator = new ThesisCreator(); break;
            default: System.out.println("Invalid type!"); return;
        }

        Material material = creator.createMaterial(code, title, author, category);
        Command cmd = new RegisterMaterialCommand(library, material);
        cmd.execute();

        if (!library.getUsers().isEmpty()) {
            for (UserObserver uo : userObservers) {
                publisher.removeObserver(uo);
            }
            userObservers.clear();
            for (User user : library.getUsers()) {
                UserObserver uo = new UserObserver(user.getName());
                userObservers.add(uo);
                publisher.addObserver(uo);
            }
            LibraryEvent event = new LibraryEvent("MATERIAL_REGISTERED", material.getTitle(), "Admin", LocalDateTime.now());
            publisher.notifyObserver(event);
        }
    }

    private void listMaterials() {
        Command cmd = new ListMaterialsCommand(library);
        cmd.execute();
    }

    private void loanMaterial() {
        System.out.println("\n--- Loan Material ---");
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        User user = library.findUser(userId);

        if (user == null) {
            System.out.println("User not found! Please register first (option 10).");
            return;
        }

        String userType = user.getType().toLowerCase();
        switch (userType) {
            case "student": user.setStrategy(new StudentLoanStrategy()); break;
            case "professor": user.setStrategy(new ProfessorLoanStrategy()); break;
            case "visitor": user.setStrategy(new VisitorLoanStrategy()); break;
            default: user.setStrategy(currentStrategy);
        }

        System.out.print("Material Code: ");
        String code = scanner.nextLine();
        Material material = library.findMaterial(code);

        if (material == null) {
            System.out.println("Material not found!");
            return;
        }

        if (!material.isAvailable()) {
            System.out.println("Material is NOT available for loan. Currently loaned.");
            return;
        }

        int activeLoans = 0;

        for (Loan loan : library.getLoanHistory()) {
            if (loan.getUser() != null &&
                    loan.getUser().getId().equals(user.getId()) &&
                    !loan.getStatus().equalsIgnoreCase("returned")) {
                activeLoans++;
            }
        }

        if (activeLoans >= config.getMaxLoans()) {
            System.out.println("User has reached the maximum number of loans ("
                    + config.getMaxLoans() + "). Cannot loan more materials.");
            return;
        }

        Command cmd = new LoanMaterialCommand(library, user, material);
        cmd.execute();

        LibraryEvent event = new LibraryEvent("MATERIAL_LOANED", material.getTitle(), user.getName(), LocalDateTime.now());
        publisher.notifyObserver(event);
    }

    private void returnMaterial() {
        System.out.println("\n--- Return Material ---");
        System.out.print("Material Code: ");
        String code = scanner.nextLine();

        Material material = library.findMaterial(code);

        if (material == null) {
            System.out.println("Material not found!");
            return;
        }

        Loan loanToReturn = null;

        for (Loan loan : library.getLoanHistory()) {
            if (loan.getMaterial().getCode().equals(code) &&
                    !loan.getStatus().equalsIgnoreCase("returned")) {
                loanToReturn = loan;
                break;
            }
        }

        if (loanToReturn == null) {
            System.out.println("No active loan found for this material.");
            return;
        }

        Command cmd = new ReturnMaterialCommand(loanToReturn);
        cmd.execute();

        LibraryEvent event = new LibraryEvent(
                "MATERIAL_RETURNED",
                material.getTitle(),
                loanToReturn.getUser() != null ? loanToReturn.getUser().getName() : "User",
                LocalDateTime.now());

        publisher.notifyObserver(event);
    }

    private void deleteMaterial() {
        System.out.println("\n--- Delete Material ---");
        System.out.print("Material Code: ");
        String code = scanner.nextLine();
        Command cmd = new DeleteMaterialCommand(library, code);
        cmd.execute();
    }

    private void checkAvailability() {
        System.out.println("\n--- Check Availability ---");
        System.out.print("Material Code: ");
        String code = scanner.nextLine();
        Command cmd = new CheckAvailabilityCommand(library, code);
        cmd.execute();
    }

    private void viewLoanHistory() {
        System.out.println("\n--- Loan History ---");

        LoanHistoryIterator iterator = library.createLoanIterator();

        if (!iterator.hasNext()) {
            System.out.println("No loan history available.");
            return;
        }

        while (iterator.hasNext()) {
            Loan loan = (Loan) iterator.next();

            System.out.println("Material: " + loan.getMaterial().getTitle() +
                    " | Code: " + loan.getMaterial().getCode() +
                    " | User: " + (loan.getUser() != null ? loan.getUser().getName() : "N/A") +
                    " | Status: " + loan.getStatus());
        }
    }

    private void changeStrategy() {
        System.out.println("\n--- Change Loan Strategy ---");
        System.out.println("1. Student (7 days, $1/day fine)");
        System.out.println("2. Professor (14 days, $2/day fine)");
        System.out.println("3. Visitor (3 days, $3/day fine)");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: currentStrategy = new StudentLoanStrategy(); break;
            case 2: currentStrategy = new ProfessorLoanStrategy(); break;
            case 3: currentStrategy = new VisitorLoanStrategy(); break;
            default: System.out.println("Keeping current strategy"); return;
        }
        System.out.println("Strategy updated successfully!");
    }

    private void showConfig() {
        System.out.println("\n--- Library Configuration ---");
        System.out.println("Name: " + config.getLibraryName());
        System.out.println("Max Loans: " + config.getMaxLoans());
        System.out.println("Base Fine: $" + config.getBaseFine());
    }

    private void registerUser() {
        System.out.println("\n--- Register User ---");
        System.out.print("User ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Type (admin/student/professor/visitor): ");
        String type = scanner.nextLine();

        User user = new User(id, name, type);
        Command cmd = new AddUserCommand(library, user);
        cmd.execute();
    }

    private void listUsers() {
        Command cmd = new ListUsersCommand(library);
        cmd.execute();
    }

    private void viewLoanedMaterials() {
        System.out.println("\n--- Loaned Materials ---");
        boolean hasLoans = false;
        for (Loan loan : library.getLoanHistory()) {
            if (!loan.getStatus().equalsIgnoreCase("returned")) {
                hasLoans = true;
                System.out.println("Material: " + loan.getMaterial().getTitle() + 
                                   " | Code: " + loan.getMaterial().getCode() +
                                   " | Loaned to: " + (loan.getUser() != null ? loan.getUser().getName() : "N/A") +
                                   " | Status: " + loan.getStatus());
            }
        }
        if (!hasLoans) {
            System.out.println("No materials currently on loan.");
        }
    }

    public Library getLibrary() {
        return library;
    }
}
