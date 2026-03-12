package StrategyDP;

public class Client {
    public static void main(String[] args) {
        GoogleMaps g = new GoogleMaps();
        g.chooseStrategy(TravelMode.CAR);
    }
}
