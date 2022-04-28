package com.example.game.logic.ObserverInterface;

public interface IObservable {
    void RegisterObserver(IObserver iObserver);
    void RemoveObserver(IObserver iObserver);
    void NotifyObservers();
}
