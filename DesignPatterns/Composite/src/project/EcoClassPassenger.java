package project;

import java.util.ArrayList;

public class EcoClassPassenger extends Passenger{
   private ArrayList<Passenger> passengers = new ArrayList<>();
   private int count  = 0;

   EcoClassPassenger(){}

    @Override
    public void removeBaggage() {
        baggageWeight-=passengers.get(count).getBaggageWeight();
        passengers.get(count).baggageWeight = 0;
        count++;
    }

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
