//package org.example.strategy;
//
//import org.example.models.Board;
//import org.example.models.Move;
//
//public class MediumBotPlayingStrategy implements BotPlayingStrategy{
//    @Override
//    public Move makeMove(Board board){
//        return null;
//    }
//}

package org.example.strategy;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Move;
import org.example.models.enums.CellState;
import org.example.strategy.BotPlayingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediumBotPlayingStrategy implements BotPlayingStrategy {

    private Random random;

    public MediumBotPlayingStrategy() {
        this.random = new Random();
    }

    @Override
    public Move makeMove(Board board) {

        // Store all empty cells
        List<Cell> emptyCells = new ArrayList<>();

        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {

                Cell cell = board.getCells().get(row).get(col);

                if (cell.getCellState().equals(CellState.EMPTY)) {
                    emptyCells.add(cell);
                }
            }
        }

        // Pick one random empty cell
        int randomIndex = random.nextInt(emptyCells.size());
        Cell randomCell = emptyCells.get(randomIndex);

        return new Move(null, randomCell);
    }
}

