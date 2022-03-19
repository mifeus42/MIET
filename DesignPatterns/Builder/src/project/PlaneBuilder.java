package project;

import java.util.ArrayList;

public class PlaneBuilder extends TransportBuilder{
    @Override
    public void createTransport() {
        transport = new Transport();
    }

    @Override
    public void buildDriver() {
        transport.setDriver(new Driver(DriveCategory.AVIATOR));
    }

    @Override
    public void setMaxPassenger() {
        transport.setMaxPassengers(300);
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
    @Override
    public void buildFood() {
        ArrayList<Food> foods = new ArrayList<>();
        for(int i = 0; i < transport.getMaxPassengers();i++){
            Food food = Food.values()[(int) (Math.random() * Food.values().length)];
            foods.add(food);
        }
        transport.setFoods(foods);
    }
}
