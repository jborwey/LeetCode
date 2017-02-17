/**
 * Created by JTB on 2/17/2017.
 */
public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int height = grid.length;
        int width = grid[0].length;

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(grid[i][j] == 1){
                    perimeter += checkGrid(grid, i, j, -1, 0, height, width);
                    perimeter += checkGrid(grid, i, j, 1, 0, height, width);
                    perimeter += checkGrid(grid, i, j, 0, -1, height, width);
                    perimeter += checkGrid(grid, i, j, 0, 1, height, width);
                }
            }
        }
        return perimeter;
    }

    private static int checkGrid(int[][] grid, int row, int column, int offsetRow, int offsetColumn, int height, int width){
        int iNeighbor = row + offsetRow;
        int jNeighbor = column + offsetColumn;

        if(iNeighbor < 0 || jNeighbor < 0  || iNeighbor >= height || jNeighbor >= width){
            return 1;
        }

        // check if there is empty space to add length to the island perimeter
        if(grid[iNeighbor][jNeighbor] == 0){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}};
        int perimeter = islandPerimeter(grid);
        System.out.println(perimeter);
    }
}
