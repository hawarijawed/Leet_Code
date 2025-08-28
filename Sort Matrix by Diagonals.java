/*
You are given an n x n square matrix of integers grid. Return the matrix such that:

The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
The diagonals in the top-right triangle are sorted in non-decreasing order.
*/

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        
        int m = grid.length;

        for(int i=0; i<m; i++){
            List<Integer> lst = new ArrayList<>();
            for(int j=0; i+j <m; j++){
                lst.add(grid[i+j][j]);
            }

            lst.sort(Collections.reverseOrder());
            for(int j=0; i+j <m; j++){
                grid[i+j][j] = lst.get(j);
            }
        }

        for(int j=1; j<m; j++){
            List<Integer> lst = new ArrayList<>();
            for(int i=0; i+j<m; i++){
                lst.add(grid[i][j+i]);
            }
            Collections.sort(lst);

            for(int i=0; i+j<m; i++){
                grid[i][j+i] = lst.get(i);
            }
        }

        return grid;
    }
}
