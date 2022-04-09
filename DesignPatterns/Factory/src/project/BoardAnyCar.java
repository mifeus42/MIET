package project;

import java.util.ArrayList;

public abstract class BoardAnyCar {
    protected Driver driver;
    protected ArrayList<Passenger> passengers = new ArrayList<>();
    protected int maxPassengers;

    protected abstract void assignBoardDriver();
    protected abstract void letBoardPassenger();
    public abstract void info();
}
