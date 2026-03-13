package observer;

public class UserObserver implements IObserver{

    private String userName;

    public UserObserver(String userName){
        this.userName= userName;
    }

    @Override
    public void update(LibraryEvent event){
        System.out.println("[USER - "+userName+"]"
                +event.getEventType()
                +"-"+event.getMaterialName());
    }

}
