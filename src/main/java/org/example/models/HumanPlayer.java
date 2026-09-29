package org.example.models;

import org.example.models.enums.PlayerType;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner sc;
    public HumanPlayer(String name, Symbol symbol, PlayerType playerType){

        super(name,symbol,playerType);
        sc = new Scanner(System.in);
    }

    public Move makeMove(Board board){

        //for human move we need row and column
        System.out.println("Please enter the row index");
        int row = sc.nextInt();

        System.out.println("Pleae enter the column index");
        int col =sc.nextInt();

        //before creating the move,validate the cell,
        //if it is empty or not

        return new Move(this,new Cell(row,col));
    }

    private boolean validateMove(Board board, int row, int col){

        return false;
    }
}
