package project;

import java.util.ArrayList;

public class Plane extends Passenger{
    private int maxBaggageWeight;
    private ArrayList<Passenger> passengers = new ArrayList<>();

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
        public void addPassenger(Passenger passenger) {
            passengers.add(passenger);
            baggageWeight+=passenger.getBaggageWeight();
        }

    @Override
    public void printPassenger(){
        for (Passenger passenger: passengers) {
            System.out.println(passenger.getClass());
            passenger.printPassenger();
        }
    }
    }
