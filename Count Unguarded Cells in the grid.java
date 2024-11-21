/*
You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.
A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.

Return the number of unoccupied cells that are not guarded.
*/
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int [][] grid = new int[m][n];
        // mark wall = -1, guard = 1, unguarded cell = 0
        //Populating grid matrix with walls
        for(int [] wall: walls){
            grid[wall[0]][wall[1]] = -1;
        }
        //Populating grid matrix with guards
        for(int [] guard: guards){
            grid[guard[0]][guard[1]] = 1;
        }
        
        //Marking the guarded cell
        for(int [] guard: guards){
            int r = guard[0];
            int c = guard[1];

            // Up visit
            for(int i= r-1; i>=0 && grid[i][c] != -1 && grid[i][c] != 1; i--){
                grid[i][c] = 2;
            }

            //Down visit
            for(int i = r+1; i < m && grid[i][c] != -1 && grid[i][c] != 1; i++){
                grid[i][c] = 2;
            }

            //Left visit
            for(int i = c-1; i>=0 && grid[r][i] != -1 && grid[r][i] != 1; i--){
                grid[r][i] = 2;
            }

            //Right visit
            for(int i = c+1; i<n && grid[r][i] != -1 && grid[r][i] != 1; i++){
                grid[r][i] = 2;
            }
        }

        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    res++;
                }
            }
        }

        return res;
    }
}
