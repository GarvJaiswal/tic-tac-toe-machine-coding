package org.example.strategy;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Move;
import org.example.models.enums.CellState;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board){
    //first empty cell
        for(int row = 0; row < board.getSize(); row++){
            for(int col = 0; col < board.getSize(); col++){
                if(board.getCells().get(row).get(col).getCellState().equals(CellState.EMPTY)){
                    return new Move(null,new Cell(row, col));
                }
            }
        }
        return null;
    }
}
