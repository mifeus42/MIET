package project;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M= Integer.parseInt(scanner.nextLine());

        ArrayList<BoardBus> boardBusList = new ArrayList<>();
        ArrayList<BoardTaxi> boardTaxiList = new ArrayList<>();

        for(int i = 0;i< N;i++){
            boardBusList.add(new BoardBus());
        }
        for(int i = 0;i<M;i++) {
            boardTaxiList.add(new BoardTaxi());
        }

        for (BoardBus bus:boardBusList) {
            bus.info();
        }
        for (BoardTaxi taxi:boardTaxiList) {
            taxi.info();
        }
    }
}
