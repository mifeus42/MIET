package project;

public class Passenger {
    protected int baggageWeight;
    Passenger(){}
    Passenger(int baggageWeight){this.baggageWeight = baggageWeight;}
    public int getBaggageWeight(){
        return baggageWeight;
    };
    public void addPassenger(Passenger passenger){};
    public void removeBaggage(){};
    public void printPassenger(){
        System.out.println(baggageWeight);
    }
}
