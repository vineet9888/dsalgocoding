package com.ds.algo.problem.solving.AmazonPrepration;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {

    public static void main(String[] args) {
        Character grid[][] = new Character[][]{
                        {'O', 'O', 'O', 'O'},
                        {'D','O','D', 'O'},
                        {'O','O','O','O'},
                        {'O','D','D','X'}
                };

        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(0, 0 , 0));
        int row[] = new int[]{0 , -1 , 0 , 1};
        int col[] = new int[]{-1 , 0 , 1 , 0};
        int rows = grid.length;
        int cols = grid[0].length;
        boolean foundAns = false;
        grid[0][0] = 'D';
        int ans = -1;
        while(!queue.isEmpty()) {
            if(ans != -1) {
                break;
            }
            Item item = queue.poll();
            // System.out.println("vineet sharma");
            for(int i = 0 ; i < 4;i++) {
                int newRow = item.row + row[i];
                int newCol = item.col + col[i];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] != 'D') {
                    if(grid[newRow][newCol] == 'X') {
                        // System.out.println("This is the answer");
                        ans = item.move + 1;
                        break;
                    }
                    grid[newRow][newCol] = 'D';
                    queue.add(new Item(newRow , newCol , item.move + 1));
                }
            }
        }
        System.out.println("Shortest path is of distance " + ans);

    }
}

class Item {
    int row;
    int col;
    int move;
    Item(int row , int col , int move) {
        this.row = row;
        this.col= col;
        this.move = move;
    }
}
