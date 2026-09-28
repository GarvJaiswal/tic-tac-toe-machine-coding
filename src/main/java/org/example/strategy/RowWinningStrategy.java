package org.example.strategy;

import org.example.models.Board;
import org.example.models.Move;
import org.example.models.Player;
import org.example.models.enums.PlayerType;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{
//    row hashmap
    private int size;
    private HashMap<Character,Integer> rowMaps[];

    public RowWinningStrategy(int size){
        this.size = size;
        this.rowMaps = new HashMap[size];

        for(int i = 0; i < size; i++){
            rowMaps[i] = new HashMap<>();
        }
    }
    @Override
    public boolean checkWinner(Move move) {
        //get curr player
        Player currentPlayer = move.getPlayer();

        //get curr row
        int row = move.getCell().getRow();

        //HashMap of curr row
        HashMap<Character,Integer> currRowMap = rowMaps[row];
        Character character = currentPlayer.getSymbol().getCharacter();

        if(!currRowMap.containsKey(character)){
            currRowMap.put(character,0);
        }
        currRowMap.put(character,currRowMap.get(character)+1);

        return currRowMap.get(character) == size;
    }
}
