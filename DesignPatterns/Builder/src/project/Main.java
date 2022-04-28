package project;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();
        TaxiBuilder taxiBuilder = new TaxiBuilder();
        BusBuilder busBuilder = new BusBuilder();

        Transport transportTaxi = director.createTransport(taxiBuilder);
        Transport transportBus = director.createTransport(busBuilder);

        transportTaxi.info();
        transportBus.info();

    }
}
