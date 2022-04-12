package project;

public class Director {
    public Transport createTransport(TransportBuilder transportBuilder){
        transportBuilder.createTransport();
        transportBuilder.buildDriver();
        transportBuilder.buildMaxPassenger();
        transportBuilder.buildChildChair();
        transportBuilder.buildPassengers();
        return transportBuilder.getTransport();
    }

}
