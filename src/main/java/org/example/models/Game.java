package org.example.models;

import org.example.models.enums.CellState;
import org.example.models.enums.GameState;
import org.example.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private  Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextTurnIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(int size, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
        this.nextTurnIndex = 0;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextTurnIndex() {
        return nextTurnIndex;
    }

    public void setNextTurnIndex(int nextTurnIndex) {
        this.nextTurnIndex = nextTurnIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void makeMove(){
        Player currentPlayer = players.get(nextTurnIndex);
        System.out.println("This is " + currentPlayer.getName() + "'s turn");
        Move move = currentPlayer.makeMove(board);
        nextTurnIndex = (nextTurnIndex + 1) % players.size();

        //fill the cell in the board
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell currentCell = this.board.getCells().get(row).get(col);
        currentCell.setPlayer(currentPlayer);
        currentCell.setCellState(CellState.FILLED);

        this.moves.add(move);

        //check winner after every move
        if(checkWinner(move)){
            this.winner = currentPlayer;
            this.gameState = GameState.ENDED;
            System.out.println(currentPlayer.getName()+ " has won the game");
        }else if (moves.size() == this.board.getSize() * this.board.getSize()){
            //draw
            this.gameState = GameState.DRAW;
        }

    }

    private boolean checkWinner(Move move){
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.checkWinner(move)){
                return true;
            }
        }
        return false;
    }

    public static class Builder{
        private int size;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public int getSize() {
            return size;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Game build(){
            //validate game object before building
            return new Game(size, players, winningStrategies);
        }

//        private void validateNumberOfPlayers(){
//
//        }
//        private void validateNumberOfBots(){
//
//        }
//        private void validateUniqueSymbols(){
//
//        }
    }
}
