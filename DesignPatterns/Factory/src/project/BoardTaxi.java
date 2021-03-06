package project;

public class BoardTaxi extends BoardAnyCar{
    public BoardTaxi(){
        maxPassengers = 4;
        assignBoardDriver();
        letBoardPassenger();
    }
    @Override
    public void assignBoardDriver() {
        driver = new TaxiDriver();
    }
    @Override
    public void letBoardPassenger() {
        for(int i=0;i<maxPassengers;i++){
            passengers.add(new TaxiPassenger());
        }
    }
    @Override
    public void info() {
        System.out.println(driver);
        for (Passenger passenger : passengers) {
            System.out.println(passenger.name);
        }
    }
}
