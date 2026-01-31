import controllers.GameController;
import enums.GameState;
import enums.PlayerType;
import exceptions.BotCountInvalidException;
import exceptions.PlayerCountInvalidException;
import exceptions.UniqueSymbolInvalidException;
import models.Game;
import models.Player;
import models.Symbol;
import strategy.WinningStrategies.ColumnWinningStrategy;
import strategy.WinningStrategies.DiagonalWinningStrategy;
import strategy.WinningStrategies.RowWinningStrategy;
import strategy.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws BotCountInvalidException, PlayerCountInvalidException, UniqueSymbolInvalidException {

        Player p1 = new Player("Pratyush", new Symbol('P', null), PlayerType.HUMAN);
        Player p2 = new Player("Remon", new Symbol('R', null), PlayerType.HUMAN);

        /*
            Game -> dimensions, players, winningstrategies
         */

        // players
        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);

        // dimensions
        int dimensions = 3;

        // winning strategies
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();

        // start the game
        Game game = gameController.startGame(dimensions, players, winningStrategies);

        Scanner scanner = new Scanner(System.in);

        while(game.getGameState().equals("IN_PROGRESS")) {

            // print the board
            gameController.printBoard(game);
            gameController.makeMove(game);

            // undo the just previous move
            gameController.undoMove(game);
        }
        game.printBoard();
        if(game.getGameState().equals(GameState.ENDED)) {
            Player player = game.getPlayers().getLast();
            System.out.println("The winner is " + player.getName() + ".");
        } else if(game.getGameState().equals(GameState.DRAW)) {
            System.out.println("Game is a draw.");
        }
    }
}
