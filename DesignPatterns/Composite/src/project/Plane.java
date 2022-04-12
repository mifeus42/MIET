package project;

import java.util.ArrayList;

public class Plane extends AircraftDivision {
    private int maxBaggageWeight;
    public ArrayList<AircraftDivision> passengers = new ArrayList<>();

    Plane(int maxBaggageWeight) {
        this.maxBaggageWeight = maxBaggageWeight;
    }

    public void checkBaggage(){
        EcoClassPassenger tmpPassenger;
        for(int i = 0;;i++){
            if(passengers.get(i).getClass() == EcoClassPassenger.class) {
                tmpPassenger = (EcoClassPassenger) passengers.get(i);
                break;
            }
        }
        while(baggageWeight > maxBaggageWeight){
            baggageWeight-=tmpPassenger.getBaggageWeight();
            tmpPassenger.removeBaggage();
            baggageWeight+=tmpPassenger.getBaggageWeight();
        }
    }


    @Override
    public void addPassenger(AircraftDivision passenger) {
        passengers.add(passenger);
        baggageWeight+=passenger.getBaggageWeight();
    }

    @Override
    public void printPassenger(){
        for (AircraftDivision passenger: passengers) {
            System.out.println(passenger.getClass());
            passenger.printPassenger();
        }
    }

    @Override
    public void removePassenger(AircraftDivision passengerRemove){
        for(AircraftDivision passengerClass: passengers) {
            if(passengerRemove != passengerClass) {
                if (passengerClass.getPassengers() != null) {
                    baggageWeight-=passengerRemove.baggageWeight;
                    passengerClass.removePassenger(passengerRemove);
                    break;
                }
            }
            else {
                baggageWeight-=passengerRemove.baggageWeight;
                passengers.remove(passengerRemove);
                break;
            }
        }
    }
}
