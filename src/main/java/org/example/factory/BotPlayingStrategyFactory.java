package org.example.factory;

import org.example.models.enums.BotDifficultyLevel;
import org.example.strategy.BotPlayingStrategy;
import org.example.strategy.EasyBotPlayingStrategy;
import org.example.strategy.HardBotPlayingStrategy;
import org.example.strategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new EasyBotPlayingStrategy();
        } else if (botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)) {
            return new MediumBotPlayingStrategy();
        } else{
            return new HardBotPlayingStrategy();
        }
    }
}
