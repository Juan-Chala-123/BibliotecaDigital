package command;

import model.Library;
import model.Material;

public class CheckAvailabilityCommand implements Command {
    
    private Library library;
    private String code;

    public CheckAvailabilityCommand(Library library, String code) {
        this.library = library;
        this.code = code;
    }

    @Override
    public void execute() {
        Material material = library.findMaterial(code);
        if (material != null) {
            String status = material.isAvailable() ? "Available" : "Not Available";
            System.out.println("Material: " + material.getTitle());
            System.out.println("Code: " + material.getCode());
            System.out.println("Status: " + status);
        } else {
            System.out.println("Material not found with code: " + code);
        }
    }
}
