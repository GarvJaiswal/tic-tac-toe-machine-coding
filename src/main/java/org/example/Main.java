package org.example;

import org.example.controllers.GameController;
import org.example.models.*;
import org.example.models.enums.BotDifficultyLevel;
import org.example.models.enums.GameState;
import org.example.models.enums.PlayerType;
import org.example.strategy.ColumnWinningStrategy;
import org.example.strategy.DiagonalWinningStrategy;
import org.example.strategy.RowWinningStrategy;
import org.example.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        int size = 3;
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("Garv",new Symbol('X'),PlayerType.HUMAN));
//        players.add(new BotPlayer("Bot",new Symbol('O'),PlayerType.BOT, BotDifficultyLevel.EASY));
        players.add(new BotPlayer("Bot",new Symbol('O'),PlayerType.BOT, BotDifficultyLevel.MEDIUM));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy(size));
        winningStrategies.add(new ColumnWinningStrategy(size));
        winningStrategies.add(new DiagonalWinningStrategy(size));

        GameController  gameController = new GameController();
        Game game = gameController.startGame(size, players, winningStrategies);

        while (gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            gameController.display(game);
            gameController.makeMove(game);
        }

        //game is either won or drawn
        if(gameController.getGameState(game).equals(GameState.ENDED)){
            gameController.display(game);
            System.out.println(game.getWinner().getName()+ "  won game");

        }else{
            gameController.display(game);
            System.out.println("Game has drawn");
        }
    }
}

