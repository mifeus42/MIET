package project;

public class Passenger {
    protected PassengerCategory passengerCategory;

    public Passenger(PassengerCategory passengerCategory){
        this.passengerCategory = passengerCategory;
    }

    @Override
    public String toString() {
        return passengerCategory.toString();
    }
}
