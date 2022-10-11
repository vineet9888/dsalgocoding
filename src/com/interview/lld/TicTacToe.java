package com.interview.lld;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TicTacToe {

    public static void main(String[] args) {
        Player vineet = new Player("Vineet Sharma" , PieceType.X);
        Player anmol = new Player("Anmol Sharma" , PieceType.O);
        List<Player> players = new ArrayList<>();
        players.add(vineet);
        players.add(anmol);
        StartingPlayerPickerStrategy startingPlayerPickerStrategy = new RandomPlayerPickingStrategy(players.size());
        Board board = new Board(3 ,3 , players , startingPlayerPickerStrategy);
        board.start();
    }
}

abstract class StartingPlayerPickerStrategy {
    int noOfPlayers;
    StartingPlayerPickerStrategy(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }

    abstract int getStartingPlayer();
}

class RandomPlayerPickingStrategy extends StartingPlayerPickerStrategy {

    RandomPlayerPickingStrategy(int noOfPlayers) {
        super(noOfPlayers);
    }

    @Override
    int getStartingPlayer() {
        Random rand;
        return ThreadLocalRandom.current().nextInt(1 , noOfPlayers);
    }
}



class Board {

    private List<Player> players;
    int row;
    int col;
    Cell grid[][];
    StartingPlayerPickerStrategy startingPlayerPickerStrategy;

    public Board(int row , int col , List<Player> players, StartingPlayerPickerStrategy startingPlayerPickerStrategy) {
        this.row = row;
        this.col = col;
        grid = new Cell[row][col];
        this.startingPlayerPickerStrategy = startingPlayerPickerStrategy;
        this.players = players;
        initializeBoard();
    }

    public void start() {
        Integer startingPlayer = this.startingPlayerPickerStrategy.getStartingPlayer();
        while (true) {
            Player currentPlayer = players.get(startingPlayer-1);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter row & col for "+ currentPlayer.name + " in row,col format : ");
            String rowColPair = scanner.next();
            String arr[] = rowColPair.split(",");
            Position position = new Position(Integer.valueOf(arr[0]) , Integer.valueOf(arr[1]));
            if(checkForWin(position)) {
                System.out.println(currentPlayer.name + " won");
                break;
            }
            if(isValidMove(position)) {
                updateBoardState(position , currentPlayer);
                print();
                startingPlayer = (startingPlayer == 1) ? 2 : 1;
            } else {
                System.out.println();
            }
        }
    }

    private void initializeBoard() {
        for(int i = 0 ;i < row;i++) {
            for(int j = 0 ; j < col;j++) {
                grid[i][j] = new Cell(null , false);
            }
        }
    }

    private void print() {
        for(int i = 0 ; i < row;i++) {
            for(int j = 0 ; j < col;j++) {
                if(grid[i][j].player != null) {
                    System.out.print(grid[i][j].player.pieceType + " ");
                } else {
                    System.out.print("-1 ");
                }

            }
            System.out.println();
        }
    }

    private void updateBoardState(Position position , Player player) {
        grid[position.row][position.col] = new Cell(player , true);
    }

    private boolean checkForWin(Position position) {
        // if all x are there in same row , same col or same diagonal then return true
        return false;
    }

    private boolean isValidMove(Position position) {
        return !(grid[position.row][position.col].isOccupied);
    }
}


class Player {
    String name;
    PieceType pieceType;
    Player(String name, PieceType pieceType) {
        this.name = name;
        this.pieceType = pieceType;
    }
}

class Cell {
    boolean isOccupied;
    Player player;
    public Cell(Player player , boolean isOccupied) {
        this.player = player;
        this.isOccupied = isOccupied;
    }
}

class Position {
    int row;
    int col;
    Position(int row , int col) {
        this.row = row;
        this.col = col;
    }
}

enum PieceType {
    X,
    O;
}


