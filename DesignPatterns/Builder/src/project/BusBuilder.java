package project;

import java.util.ArrayList;

public class BusBuilder extends TransportBuilder {
    @Override
    public void createTransport() {
        transport = new Transport();
    }

    @Override
    public void buildDriver() {
        transport.setDriver(new Driver(DriveCategory.D));
    }

    @Override
    public void buildMaxPassenger() {
        transport.setMaxPassengers(30);
    }

    @Override
    public void buildPassengers() {
        ArrayList<Passenger> passengers = new ArrayList<>();
        for(int i = 0; i < transport.getMaxPassengers();i++){
            Passenger passenger = new Passenger(PassengerCategory.values()[(int) (Math.random() * PassengerCategory.values().length)]);
            passengers.add(passenger);
        }
        transport.setPassengers(passengers);
    }
}
