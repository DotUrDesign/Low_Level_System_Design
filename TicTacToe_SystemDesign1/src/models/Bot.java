package models;

import enums.BotDifficultyLevel;
import enums.PlayerType;
import factory.BotPlayingStrategyFactory;
import strategy.BOTStrategies.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;
    public Bot(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);    // constructor chaining
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getPlayingStrategy(botDifficultyLevel);
    }

    // Why here in this case, we can't use @Override annotation ?
    public void chooseCellToPlay(Board board) {
        this.botPlayingStrategy.chooseCellToPlay(board);
    }
}
