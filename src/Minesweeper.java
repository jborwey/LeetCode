import java.util.ArrayList;
import java.util.List;

/**
 * Created by jb039k on 4/4/2017.
 */
public class Minesweeper {

    public static char[][] updateBoard(char[][] board, int[] click) {
        int height = board.length, width = board[0].length;
        List<int[]> mineList = new ArrayList<>();

        for(int i=0; i<height; i++){

            for(int j=0; j<width; j++){
                if(board[i][j] == 'E'){
                    board[i][j] = 'B';
                }
                else if(board[i][j] == 'M'){
                    int[] mine = {i, j};
                    mineList.add(mine);

                    foundMine(board, i, j, -1, 1, height, width);
                    foundMine(board, i, j, 0, 1, height, width);
                    foundMine(board, i, j, 1, 1, height, width);
                }
            }
        }

        for(int[] mine : mineList){
            int rMine = mine[0];
            int cMine = mine[1];
            checkAdjacent(board, rMine, cMine, height, width);
            if(rMine == click[0] && cMine == click[1]){
                board[rMine][cMine] = 'X';
            }
        }

        return board;
    }

    public static void foundMine(char[][] board, int row, int column, int rowOffset, int columnOffset, int height, int width){
        int iNeighbor = row - rowOffset;
        int jNeighbor = column - columnOffset;
        if(iNeighbor < 0 || iNeighbor >= height){
            return;
        }
        if(jNeighbor < 0){
            jNeighbor += 1;
        }

        if(column == width){
            column -= 1;
        }

        for(int j=jNeighbor; j<column+1; j++){
            char tile = board[iNeighbor][j];
            if(tile == 'E' || tile == 'B'){
                board[iNeighbor][j] = '1';
            }
            else if(tile < '8'){
                board[iNeighbor][j] += 1;
            }
        }
    }

    public static void checkAdjacent(char[][] board, int row, int column, int height, int width){
        int rowStart = row - 1; int rowEnd = row + 1;
        int columnStart = column - 1; int columnEnd = column + 1;

        if(rowStart < 0){
            rowStart += 1;
        }

        if(columnStart < 0){
            columnStart += 1;
        }

        if(rowEnd > height){
            rowEnd -= 1;
        }

        if(columnEnd == width){
            columnEnd -= 1;
        }
        for(int i=rowStart; i<rowEnd; i++){
            for(int j=columnStart; j<columnEnd; j++){
                if(!adjacentNorth(board, i, j) && !adjacentEast(board, i, j, width) &&
                        !adjacentSouth(board, i, j, height) && !adjacentWest(board, i, j) && board[i][j] != 'M'){
                    board[i][j] = 'E';
                }
            }
        }

    }
    public static boolean adjacentNorth(char[][] board, int row, int column){
        if(row-1 < 0){
            return false;
        }
        else if(board[row-1][column] == 'M' || board[row-1][column] != 'B'){
            return false;
        }

        return true;
    }

    public static boolean adjacentEast(char[][] board, int row, int column, int width){
        if(column + 1 >= width){
            return false;
        }
        else if(board[row][column+1] == 'M' || board[row][column + 1] != 'B'){
            return false;
        }

        return true;
    }

    public static boolean adjacentSouth(char[][] board, int row, int column, int height){
        if(row+1 >= height){
            return false;
        }
        else if(board[row+1][column] == 'M' || board[row+1][column] != 'B'){
            return false;
        }

        return true;
    }

    public static boolean adjacentWest(char[][] board, int row, int column){
        if(column - 1 < 0){
            return false;
        }
        else if(board[row][column-1] == 'M' || board[row][column-1] != 'B'){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        char[][] minefield =
//                {   {'E', 'E', 'E', 'E', 'E'},
//                    {'E', 'E', 'M', 'E', 'E'},
//                    {'E', 'E', 'E', 'E', 'E'},
//                    {'E', 'E', 'E', 'E', 'E'}   };
//
//        int[] click = {3, 0};

        char[][] minefield =
                {       {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'M'},
                        {'E', 'M', 'E', 'E', 'E', 'E', 'E', 'E'},
                        {'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'M', 'M', 'E', 'E', 'E', 'E'} };

        int[] click = {0, 0};

        char[][] playedGame = updateBoard(minefield, click);
        for(char[] i : playedGame){
            System.out.println();
            for(char j : i){
                System.out.print(j + " ");
            }
        }
    }
}
