package project;

public class Director {
    public Transport createTransport(TransportBuilder transportBuilder){
        transportBuilder.createTransport();
        transportBuilder.buildDriver();
        transportBuilder.setMaxPassenger();
        transportBuilder.buildChildChair();
        transportBuilder.buildPassengers();
        transportBuilder.buildFood();
        return transportBuilder.getTransport();
    }

}
