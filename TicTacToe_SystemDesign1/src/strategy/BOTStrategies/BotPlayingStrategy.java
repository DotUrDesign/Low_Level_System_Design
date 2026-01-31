package strategy.BOTStrategies;

import models.Board;
import models.Cell;

public interface BotPlayingStrategy {
    public Cell chooseCellToPlay(Board board);
}
