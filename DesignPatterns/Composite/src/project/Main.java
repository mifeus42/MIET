package project;

public class Main {

    public static void fillPlane(Plane plane){
        EcoClassPassenger ecoClassPassenger = new EcoClassPassenger();
        BusinessClassPassenger businessClassPassenger = new BusinessClassPassenger();
        PremiumClassPassenger premiumClassPassenger = new PremiumClassPassenger();

        for (int i = 0; i < 2; i++) {
            plane.addPassenger(new Aviator());
        }
        for (int i = 0; i < 6; i++) {
            plane.addPassenger(new Stuart());
        }
        for (int i = 0; i < 150; i++) {
            ecoClassPassenger.addPassenger(new Passenger((int) (Math.random() * 55 + 5)));
        }
        plane.addPassenger(ecoClassPassenger);
        for (int i = 0; i < 20; i++) {
            businessClassPassenger.addPassenger(new Passenger((int) (Math.random() * 55 + 5)));
        }
        plane.addPassenger(businessClassPassenger);
        for (int i = 0; i < 10; i++) {
            premiumClassPassenger.addPassenger(new Passenger((int) (Math.random() * 55 + 5)));
        }
        plane.addPassenger(premiumClassPassenger);

        plane.checkBaggage();
    }

    public static void main(String[] args) {
        Plane plane = new Plane(3000);
        fillPlane(plane);
        plane.printPassenger();
    }
}
