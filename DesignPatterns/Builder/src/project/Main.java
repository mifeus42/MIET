package project;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();
        TaxiBuilder taxiBuilder = new TaxiBuilder();
        BusBuilder busBuilder = new BusBuilder();
        PlaneBuilder planeBuilder = new PlaneBuilder();

        Transport transportTaxi = director.createTransport(taxiBuilder);
        Transport transportBus = director.createTransport(busBuilder);
        Transport transportPlane = director.createTransport(planeBuilder);

        transportTaxi.info();
        transportBus.info();
        transportPlane.info();
    }
}
