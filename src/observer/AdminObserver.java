package observer;

public class AdminObserver implements IObserver{
    private String adminName;

    public AdminObserver(String adminName){
        this.adminName= adminName;
    }

    @Override
    public void update(String event){
        System.out.println("-Admin: "+adminName+"\n- Notification received: "+event);
    }
}
