package project;

import java.util.ArrayList;

public class AircraftDivision {
    protected int baggageWeight;
    public int place;
    AircraftDivision(){}
    public int getBaggageWeight(){
        return baggageWeight;
    };
    public void addPassenger(AircraftDivision passenger){};
    public void removePassenger(AircraftDivision passenger){removeBaggage();};
    public void removeBaggage(){};
    public void printPassenger(){
        System.out.println(baggageWeight);
    }
    public ArrayList<AircraftDivision> getPassengers(){return null;};
}
