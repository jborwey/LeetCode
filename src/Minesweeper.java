import java.util.ArrayList;
import java.util.List;

/**
 * Created by jb039k on 4/4/2017.
 */
public class Minesweeper {

    public static char[][] updateBoard(char[][] board, int[] click) {
        int height = board.length, width = board[0].length;

        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }

        List<int[]> mineList = new ArrayList<>();


        for(int i=0; i<height; i++){

            for(int j=0; j<width; j++){
                if(board[i][j] == 'E'){
                    board[i][j] = 'B';
                }
                else if(board[i][j] == 'M'){
                    int[] mine = {i, j};
                    mineList.add(mine);

                    foundMine(board, i, j, -1, -1, height, width);
                    foundMine(board, i, j, 0, -1, height, width);
                    foundMine(board, i, j, 1, -1, height, width);
                }
                else if(board[i][j] == 'B'){
                    break;
                }
            }
        }

        for(int[] mine : mineList){
            int rMine = mine[0], cMine = mine[1];
            checkAdjacent(board, rMine, cMine, height, width);

        }

        return board;
    }

    public static void foundMine(char[][] board, int row, int column, int rowOffset, int columnOffset, int height, int width){
        int iNeighbor = row + rowOffset;
        int jNeighbor = column + columnOffset;
        int columnEnd = column + 1;
        if(iNeighbor < 0 || iNeighbor >= height){
            return;
        }
        if(jNeighbor < 0){
            jNeighbor += 1;
        }

        if(columnEnd == width){
            columnEnd -= 1;
        }

        for(int j=jNeighbor; j<=columnEnd; j++){
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

        if(rowEnd >= height){
            rowEnd -= 1;
        }

        if(columnEnd >= width){
            columnEnd -= 1;
        }
        for(int i=rowStart; i<rowEnd; i++){
            for(int j=columnStart; j<=columnEnd; j++){
                if(board[i][j] != 'M' && !adjacentSpace(board, i, j, height, width)){
                    board[i][j] = 'E';
                }
            }
        }

    }
    public static boolean adjacentSpace(char[][] board, int row, int column, int height, int width){
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

        for(int i=rowStart; i<=rowEnd; i++){
            for(int j=columnStart; j<=columnEnd; j++){
                if(board[i][j] == 'B'){
                      return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        char[][] minefield =
//                {   {'E', 'E', 'E', 'E', 'E'},
//                    {'E', 'E', 'M', 'E', 'E'},
//                    {'E', 'E', 'E', 'E', 'E'},
//                    {'E', 'E', 'E', 'E', 'E'}   };
//
//        int[] click = {3, 0};
//
//        char[][] minefield =
//                {       {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'M'},
//                        {'E', 'M', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'E', 'M', 'M', 'E', 'E', 'E', 'E'} };
//
//        int[] click = {0, 0};

//        char[][] minefield =
//                {       {'B', '1', 'E', '1', 'B'},
//                        {'B', '1', 'M', '1', 'B'},
//                        {'B', '1', '1', '1', 'B'},
//                        {'B', 'B', 'B', 'B', 'B'},  };
//
//        int[] click = {1, 2};

//                char[][] minefield =
//                {       {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'M'},
//                        {'E', 'E', 'M', 'E', 'E', 'E', 'E', 'E'},
//                        {'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'E', 'M', 'M', 'E', 'E', 'E', 'E'} };
//
//        int[] click = {0, 0};

        // Line 115: java.lang.ArrayIndexOutOfBoundsException: 8
//        char[][] minefield =
//                {       {'E', 'E', 'E', 'E', 'E', 'M', 'M', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'M', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'M', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'M', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'M', 'M', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
//                        {'E', 'E', 'E', 'E', 'M', 'M', 'E', 'M'} };
//
//        int[] click = {2, 2};

        char[][] minefield =
                {       {'B', 'B', 'B', 'B', 'B', 'B', '1', 'E'},
                        {'B', '1', '1', '1', 'B', 'B', '1', 'M'},
                        {'1', '2', 'M', '1', 'B', 'B', '1', '1'},
                        {'M', '2', '1', '1', 'B', 'B', 'B', 'B'},
                        {'1', '1', 'B', 'B', 'B', 'B', 'B', 'B'},
                        {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'},
                        {'B', '1', '2', '2', '1', 'B', 'B', 'B'},
                        {'B', '1', 'M', 'M', '1', 'B', 'B', 'B'} };

        int[] click = {0, 7};

        char[][] playedGame = updateBoard(minefield, click);
        for(char[] i : playedGame){
            System.out.println();
            for(char j : i){
                System.out.print(j + " ");
            }
        }
    }
}
