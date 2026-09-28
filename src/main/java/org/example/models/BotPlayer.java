package org.example.models;

import org.example.factory.BotPlayingStrategyFactory;
import org.example.models.enums.BotDifficultyLevel;
import org.example.models.enums.PlayerType;
import org.example.strategy.BotPlayingStrategy;

public class BotPlayer extends Player{
    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStrategy playingStrategy;

    public BotPlayer(String name,
                     Symbol symbol,
                     PlayerType playerType,
                     BotDifficultyLevel difficultyLevel){
        super(name,symbol,playerType);
        this.difficultyLevel = difficultyLevel;
        this.playingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);

//        This violates SRP and OCP
//        Use factory design pattern
//        if(difficultyLevel == BotDifficultyLevel.EASY){
//            this.playingStrategy = new EasyBotPlayingStrategy();
//        }
//        else if(difficultyLevel == BotDifficultyLevel.MEDIUM){
//            this.playingStrategy = new MediumBotPlayingStrategy();
//        }
//        else{
//            this.playingStrategy = new HardBotPlayingStrategy();
//        }

    }
}
