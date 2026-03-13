package observer;

public class AdminObserver implements IObserver{
    private String adminName;

    public AdminObserver(String adminName){
        this.adminName= adminName;
    }

    @Override
    public void update(LibraryEvent event){
        System.out.println("[ADMIN - "+adminName+"]"
                +event.getEventType()
                +" | Material: "+event.getMaterialName()
                +" | User: "+event.getNameUser());
                
    }
}
