package observer;

import java.util.List;

public class LibraryEventPublisher{
    private List<IObserver> observers;

    public void addObserver(IObserver o){
        observers.add(o);
    }

    public void removeObserver(IObserver o){
        observers.remove(o);
    }

    public void notifyObserver(String event){
        for(IObserver o: observers){
            o.update(event);
        }
    }

}