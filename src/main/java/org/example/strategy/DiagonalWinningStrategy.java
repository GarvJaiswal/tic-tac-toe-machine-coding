package org.example.strategy;

import org.example.models.Board;
import org.example.models.Move;
import org.example.models.Player;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy {
    //diagonal hashmaps
    private int size;
    private HashMap<Character, Integer> leftDiagonalMap;
    private HashMap<Character, Integer> rightDiagonalMap;

    public DiagonalWinningStrategy(int size) {
        this.size = size;
        this.leftDiagonalMap = new HashMap<>();
        this.rightDiagonalMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Move move) {
        //get curr player
        Player currentPlayer = move.getPlayer();
        //get curr row
        int row = move.getCell().getRow();
        //get curr col
        int col = move.getCell().getCol();

        Character character = currentPlayer.getSymbol().getCharacter();


        if (row == col) {
            if (!leftDiagonalMap.containsKey(character)) {
                leftDiagonalMap.put(character, 0);
            }
            leftDiagonalMap.put(character, leftDiagonalMap.get(character) + 1);
            return leftDiagonalMap.get(character) == size;
        }
        if (row + col == size - 1) {
            if (!rightDiagonalMap.containsKey(character)) {
                rightDiagonalMap.put(character, 0);
            }
            rightDiagonalMap.put(character, rightDiagonalMap.get(character) + 1);
            return rightDiagonalMap.get(character) == size;
        }
        return false;
    }
}
