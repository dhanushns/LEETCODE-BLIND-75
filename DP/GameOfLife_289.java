package BLIND_75.DP;

import java.util.Arrays;

public class GameOfLife_289 {

    public static void lifeOfCells(int[][] board){

        int n = board.length;
        int m = board[0].length;

        for(int row = 0; row < n ; row++){

            for(int col = 0; col < m ; col++){

                int liveNeighbors = 0;
                int currentCell = board[row][col];
                if(currentCell == 0)
                    liveNeighbors-=1;

                for(int i = row-1; i <= row+1; i++){

                    for(int j = col-1; j <= col+1; j++){
                        if(i < n && j < m && i != -1 && j != -1)
                            if(board[i][j] == 1 || board[i][j] == 4 || board[i][j] == 3)
                                liveNeighbors++;
                    }
                }

                if(currentCell == 0 && liveNeighbors == 2)
                    board[row][col] = 2;
                else if(currentCell == 1){
                    if(liveNeighbors == 4)
                        board[row][col] = liveNeighbors;
                    if(liveNeighbors == 3)
                        board[row][col] = liveNeighbors+1;
                    if(liveNeighbors > 4)
                        board[row][col] = 1;
                    if(liveNeighbors <= 2)
                        board[row][col] = 1;
                }

            }

        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == 4)
                    board[i][j] = 1;
                else if(board[i][j] == 2)
                    board[i][j] = 1;
                else if(board[i][j] == 1)
                    board[i][j] = 0;
            }
        }

    }

    public static void main(String[] args) {

        int[][] board = new int[][] {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        lifeOfCells(board);

        for(int[] cell : board)
            System.out.println(Arrays.toString(cell));

    }

}
