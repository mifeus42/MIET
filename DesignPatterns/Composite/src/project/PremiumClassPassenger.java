package project;

import java.util.ArrayList;

public class PremiumClassPassenger extends Passenger{
    private ArrayList<Passenger> passengers = new ArrayList<>();

    PremiumClassPassenger(){}

    @Override
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        baggageWeight+=passenger.getBaggageWeight();
    }

    @Override
    public void printPassenger(){
        for (Passenger passenger: passengers) {
            passenger.printPassenger();
        }
    }
}
