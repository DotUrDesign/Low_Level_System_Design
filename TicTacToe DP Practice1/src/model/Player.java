package model;

import enums.PlayerType;

import java.util.Scanner;

public class Player {
    String name;
    String symbol;
    PlayerType playerType;
    private Scanner scanner = new Scanner(System.in);

    public Player(String name, String symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Cell chooseCellToPlay(Player player) {
        System.out.println("Choose the row no you want to play the game");
        int row = scanner.nextInt();

        System.out.println("Choose the column no you want to play the game");
        int column = scanner.nextInt();

        return new Cell(row, column, player);
    }
}
