package project;

import java.util.ArrayList;

public class Transport {
    private Driver driver;
    private boolean isGotChildChair;
    private int maxPassengers;
    private ArrayList<Food> foods= new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }
    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setIsGotChildChair(boolean isGotChildChair) { this.isGotChildChair = isGotChildChair;}

    public boolean isGotChildChair() {
        return isGotChildChair;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public void info(){
        System.out.println(driver);
        for (Passenger passenger:passengers) {
            System.out.println(passenger);
        }
        System.out.println(isGotChildChair);
            for (Food food : foods) {
                System.out.println(food);
            }
    }
}
