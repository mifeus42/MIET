package project;

import java.util.ArrayList;

public class TaxiBuilder extends TransportBuilder{
    @Override
    public void createTransport() {
        transport = new Transport();
    }

    @Override
    public void buildDriver() {
        transport.setDriver(new Driver(DriveCategory.B));
    }

    @Override
    public void buildChildChair() {
        transport.setIsGotChildChair(true);
    }

    @Override
    public void setMaxPassenger() {
        transport.setMaxPassengers(4);
    }

    @Override
    public void buildPassengers() {
        ArrayList<Passenger> passengers = new ArrayList<>();
        for(int i = 0; i < transport.getMaxPassengers();i++){
            Passenger passenger;
            do {
                passenger = new Passenger(PassengerCategory.values()[(int) (Math.random() * PassengerCategory.values().length)]);
            }while (passenger.passengerCategory != PassengerCategory.ADULT && (passenger.passengerCategory != PassengerCategory.CHILD && transport.isGotChildChair()));
            passengers.add(passenger);
        }
        transport.setPassengers(passengers);
    }
}
