package org.example.strategy;

import org.example.models.Board;
import org.example.models.Move;
import org.example.models.Player;

import java.util.HashMap;

public class ColumnWinningStrategy implements WinningStrategy{
    //col hashmap
    private int size;
    private HashMap<Character,Integer> colMaps[];

    public ColumnWinningStrategy(int size){
        this.size = size;
        this.colMaps = new HashMap[size];

        for(int i = 0; i < size; i++){
            colMaps[i] = new HashMap<>();
        }
    }
    @Override
    public boolean checkWinner(Move move) {
        //get curr player
        Player currentPlayer = move.getPlayer();

        //get curr col
        int col = move.getCell().getCol();

        //HashMap of curr row
        HashMap<Character,Integer> currColMap = colMaps[col];
        Character character = currentPlayer.getSymbol().getCharacter();

        if(!currColMap.containsKey(character)){
            currColMap.put(character,0);
        }
        currColMap.put(character,currColMap.get(character)+1);

        return currColMap.get(character) == size;
    }
}
