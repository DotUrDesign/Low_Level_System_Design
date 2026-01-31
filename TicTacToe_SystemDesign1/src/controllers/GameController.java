package controllers;

import exceptions.BotCountInvalidException;
import exceptions.PlayerCountInvalidException;
import exceptions.UniqueSymbolInvalidException;
import models.Cell;
import models.Game;
import models.Player;
import strategy.WinningStrategies.WinningStrategy;

import java.util.List;

public class GameController {
    public GameController() {

    }

    public Game startGame(int dimensions, List<Player> players, List<WinningStrategy> winningStrategies) throws BotCountInvalidException, PlayerCountInvalidException, UniqueSymbolInvalidException {
        System.out.println(dimensions);
        Game game = Game.getBuilder()
                .setDimensions(dimensions)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
        return game;
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void makeMove(Game game) {
        game.makeMove(game);
    }

    public void undoMove(Game game) {
        game.undoMove();
    }

}
