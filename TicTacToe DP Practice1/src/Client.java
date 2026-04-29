import controller.GameController;
import enums.GameState;
import enums.PlayerType;
import exceptions.BotCountInvalidException;
import exceptions.PlayerCountInvalidException;
import exceptions.UniqueSymbolInvalidException;
import model.Game;
import model.Player;
import strategy.WinningStrategy.ColumnWinningStrategy;
import strategy.WinningStrategy.DiagonalWinningStrategy;
import strategy.WinningStrategy.RowWinningStrategy;
import strategy.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws BotCountInvalidException, PlayerCountInvalidException, UniqueSymbolInvalidException {
        Player player1 = new Player(
                "Pratyush",
                "X",
                PlayerType.HUMAN
        );

        Player player2 = new Player(
                "Kira",
                "O",
                PlayerType.BOT
        );

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        int dimensions = 3;

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();

        // build the game
        Game game = gameController.startGame(dimensions, players, winningStrategies);

        while(game.getGameState().equals(GameState.IN_PROGRESS)) {
            gameController.printBoard(game);
            gameController.makeMove(game);

            gameController.undoMove(game);
        }

    }
}
