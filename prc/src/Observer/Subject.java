package Observer;

import java.util.List;
import java.util.ArrayList;

public class Subject {
    private List < Observer > observers = new ArrayList < > ();

    // Add Observer
    public void attach(Observer observer){
        observers.add(observer);
    }

    // remove Observer
    public void detach(Observer observer){
        observers.remove(observer);
    }

    // notice Observer
    public void notifyObservers(String msg) {
        for (Observer observer: observers) {
            observer.receive(msg);
        }
    }

}


