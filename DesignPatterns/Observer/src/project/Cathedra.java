package project;

import java.util.ArrayList;

public class Cathedra implements IObserver{
    IObservable deanery;
    public Cathedra(IObservable observable){
        deanery = observable;
        deanery.addObserver(this);
    }

    @Override
    public void update(Object obj) {
        System.out.println("Cathedra was notified");
    }
}
