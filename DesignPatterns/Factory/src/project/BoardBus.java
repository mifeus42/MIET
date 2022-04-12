package project;

public class BoardBus extends BoardAnyCar{
    public BoardBus(){
        maxPassengers = 30;
        assignBoardDriver();
        letBoardPassenger();
    }
    @Override
    protected void assignBoardDriver() {
        driver = new BusDriver();
    }
    @Override
    protected void letBoardPassenger() {
        for(int i=0;i<maxPassengers;i++){
            passengers.add(new BusPassenger());
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
