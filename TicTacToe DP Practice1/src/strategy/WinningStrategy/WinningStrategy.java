package strategy.WinningStrategy;

import model.Game;

public interface WinningStrategy {
    boolean checkWinner(Game game);

    void undoMove(Game game);
}
