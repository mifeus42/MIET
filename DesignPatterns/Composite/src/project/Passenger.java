package project;

public class Passenger extends AircraftDivision {
    Passenger(int baggageWeight, int place){
        this.baggageWeight = baggageWeight;
        this.place = place;
    }
    @Override
    public void printPassenger() {
        System.out.println("Место " + place);
        super.printPassenger();
    }

}
