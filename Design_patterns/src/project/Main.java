package project;

public class Main {

    public static void main(String[] args) {
        BoardAnyCar boardBus = new BoardBus();
        BoardAnyCar boardTaxi = new BoardTaxi();

        boardTaxi.info();
        boardBus.info();
    }
}
