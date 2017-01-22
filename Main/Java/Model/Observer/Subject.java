package Model.Observer;

/**
 * Created by yanice on 22/01/17.
 */
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(Observer observer);
    void notifyObservers();
}
