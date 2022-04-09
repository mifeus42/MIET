package project;

import java.util.ArrayList;

public class EcoClassPassenger extends AircraftDivision {
   private ArrayList<AircraftDivision> passengers = new ArrayList<>();
   private int count  = 0;

   EcoClassPassenger(){}

    @Override
    public void removeBaggage() {
        baggageWeight-=passengers.get(count).getBaggageWeight();
        passengers.get(count).baggageWeight = 0;
        count++;
    }

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
