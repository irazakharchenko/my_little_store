import java.util.ArrayList;

public class Observable {

    private ArrayList<Observer> observers = new ArrayList<>();

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public boolean addObserver(Observer ob){
        observers.add(ob);
        return true;
    }

    public boolean removeObserver(Observer ob){
        return observers.remove(ob);
    }

    public boolean notifyObservers(){
        for(Observer ob : observers){
            System.out.println("Notify observer.");
        }
        return true;
    }
}
