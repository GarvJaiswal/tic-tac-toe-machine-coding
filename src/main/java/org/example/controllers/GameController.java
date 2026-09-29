package org.example.controllers;

import org.example.models.Game;
import org.example.models.Player;
import org.example.models.enums.GameState;
import org.example.strategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int size,
                          List<Player> players,
                          List<WinningStrategy> winningStrategies){
        return Game.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void display(Game game){
        game.getBoard().display();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

}
