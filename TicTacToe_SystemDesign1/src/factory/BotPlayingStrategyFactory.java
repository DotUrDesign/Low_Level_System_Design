package factory;

import enums.BotDifficultyLevel;
import strategy.BOTStrategies.BotPlayingStrategy;
import strategy.BOTStrategies.EasyBotPlayingStrategy;
import strategy.BOTStrategies.HardBotPlayingStrategy;
import strategy.BOTStrategies.MediumBotPlayingStrategy;

/*
    Just a point to remember, this line is completely out of context.
    I am writing this line, may be one day I can come across this line.

    Whenever you see some transactions are going on, and some third party tools are getting involved - like GPay, PhonePe...
    then there would be an involvement of "ADAPTER DESIGN PATTERN".
 */
public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)) {
            return new EasyBotPlayingStrategy();
        } else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)) {
            return new MediumBotPlayingStrategy();
        } else if(botDifficultyLevel.equals(BotDifficultyLevel.HARD)) {
            return new HardBotPlayingStrategy();
        }
        return null;
    }
}
