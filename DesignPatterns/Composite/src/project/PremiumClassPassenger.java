package project;

import java.util.ArrayList;

public class PremiumClassPassenger extends AircraftDivision {
    private ArrayList<AircraftDivision> passengers = new ArrayList<>();

    PremiumClassPassenger(){}

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
        baggageWeight-=passenger.baggageWeight;
        passengers.remove(passenger);
    }

    @Override
    public ArrayList<AircraftDivision> getPassengers() {
        return passengers;
    }
}
