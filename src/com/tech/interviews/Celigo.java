package com.tech.interviews;

import java.util.HashMap;
import java.util.Map;

public class Celigo {

    public static void main(String[] args) {
        int stairs = 3;
        Map<Integer , Integer> map = new HashMap<>();
        System.out.println(waysToReachTop(stairs , 0 , map));
        int info[] = new int[]{0,0,0};
        System.out.println(noOfWays(stairs ,info));
    }

    private static int noOfWays(int n , int info[]) {
        int ans = 0;
        int arr[] = new int[n + 1];
        if(info[0] == 1) {
            arr[1] = 1;
        }
        if(info[1] == 1) {
            arr[2] = 2;
        }
        for(int i  = 3 ; i <= n;i++) {
            if(info[i-1] == 1) {
                arr[i] = arr[i-1] + arr[i-2];
            } else {
                arr[i] = 0;
            }
        }
        return arr[n];
    }

    private static int waysToReachTop(int n , int currStep , Map<Integer , Integer> map) {
        int ans = 0;
        if(currStep > n) {
            return 0;
        }
        if(map.containsKey(currStep)) {
            return map.get(currStep);
        }
        if(currStep == n) {
            return 1;
        }
        ans = waysToReachTop(n , currStep + 1 , map) +
        waysToReachTop(n , currStep + 2 , map);
        map.put(currStep , ans);
        return ans;
    }
}

class Board {
    Cell grid[][];
    Board(int size) {
        this.grid = new Cell[size][size];
    }

    void makeMove() {

    }
}


abstract class MoveValidator {

}


class Cell {
    int row;
    int col;
    Piece peice;
    Playerr player;
}

class Playerr {
    String name;
    PLAYER_TYPE playerType;
}


enum PLAYER_TYPE {
    WHITE,
    BLACK;
}

abstract class Piece {
    abstract void move(int row , int col , int destinationRow , int destinationCol);
    abstract boolean canMove(int row , int col , int destinationRow , int destinationCol);
}


class Elephant extends Piece {

    @Override
    void move(int row , int col , int destinationRow , int destinationCol) {

    }

    @Override
    boolean canMove(int row , int col , int destinationRow , int destinationCol) {
        return false;
    }
}