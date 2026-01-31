package strategy.WinningStrategies;

import models.Game;
import models.Move;

public interface WinningStrategy {
    public boolean checkWinner(Game game);

    public void undoMove(Move move, int N);
}
