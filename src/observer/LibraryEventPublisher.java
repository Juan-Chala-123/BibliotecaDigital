package observer;

import java.util.List;
import java.util.ArrayList;

public class LibraryEventPublisher{
    private List<IObserver> observers= new ArrayList<>();

    public void addObserver(IObserver o){
        observers.add(o);
    }

    public void removeObserver(IObserver o){
        observers.remove(o);
    }

    public void notifyObserver(LibraryEvent event){
        for(IObserver o: observers){
            o.update(event);
        }
    }

}