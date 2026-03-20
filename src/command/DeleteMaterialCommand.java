package command;

import model.Library;
import model.Material;

public class DeleteMaterialCommand implements Command {
    
    private Library library;
    private String code;

    public DeleteMaterialCommand(Library library, String code) {
        this.library = library;
        this.code = code;
    }

    @Override
    public void execute() {
        Material material = library.findMaterial(code);
        if (material != null) {
            if (library.isMaterialOnLoan(code)) {
                System.out.println("Cannot delete. Material is currently on loan.");
                return;
            }
            library.getMaterials().remove(material);
            System.out.println("Material deleted: " + material.getTitle());
        } else {
            System.out.println("Material not found with code: " + code);
        }
    }
}
