package project;

import java.util.ArrayList;

public class BusinessClassPassenger extends AircraftDivision {
    private ArrayList<AircraftDivision> passengers = new ArrayList<>();

    BusinessClassPassenger(){}

    @Override
    public void addPassenger(AircraftDivision passenger) {
        passengers.add(passenger);
        baggageWeight+=passenger.getBaggageWeight();
    }

    @Override
    public void printPassenger(){
        for (AircraftDivision passenger: passengers) {
            passenger.printPassenger();
        }
    }

    @Override
    public void removePassenger(AircraftDivision passenger) {
        passengers.remove(passenger);
    }

    @Override
    public ArrayList<AircraftDivision> getPassengers() {
        return passengers;
    }
}
