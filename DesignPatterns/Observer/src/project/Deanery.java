package project;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deanery implements IObserver, IObservable{
    IObservable academicPerformance;

    ArrayList<IObserver> observers;

    public Deanery(IObservable observable){
        observers = new ArrayList<>();

        academicPerformance = observable;
        academicPerformance.addObserver(this);
    }

    @Override
    public void update(Object obj) {
        LocalDate dateFilling = (LocalDate) obj;
        LocalDate dateCurrent = LocalDate.now();

        if(dateCurrent.isAfter(dateFilling.plusDays(7))){
            notifyObservers();
        }
    }

    @Override
    public void addObserver(IObserver iObserver) {
        observers.add(iObserver);
    }

    @Override
    public void removeObserver(IObserver iObserver) {
        observers.remove(iObserver);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer: observers) {
            observer.update(academicPerformance);
        }
    }
}
