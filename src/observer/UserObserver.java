package observer;

public class UserObserver implements IObserver{

    private String userName;

    public UserObserver(String userName){
        this.userName= userName;
    }

    @Override
    public void update(String event){
        System.out.println("-User: "+userName+"\n- Notification received: "+event);
    }

}
