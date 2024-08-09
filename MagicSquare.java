/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
	public int findRowSum(int[][] grid, int r, int c) {
		boolean visited[] = new boolean[10];
		int sum = 0;
		for(int i=0; i<3; i++) {
			int rowSum=0;
			for(int j=0; j<3; j++) {
				int val = grid[r+i][c+j];
				if(val==0||val>=10 ||visited[val]) {
					return -1;
				}
				visited[val] = true;
				rowSum += val;
			}
			if(i==0) {
				sum = rowSum;
			}
			else {
				if(sum!=rowSum) {
					return -1;
				}
			}
		}
		return sum;
	}

	public int findColSum(int[][] grid, int r, int c) {
		int sum = 0;
		for(int j=0; j<3; j++) {
			int colSum=0;
			for(int i=0; i<3; i++) {
				int val = grid[r+i][c+j];
				colSum += val;
			}
			if(j==0) {
				sum = colSum;
			}
			else {
				if(sum!=colSum) {
					return -1;
				}
			}
		}
		return sum;
	}

	public int diagonalSum(int [][] grid, int r, int c) {
		int sum1 = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
		int sum2 = grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];

		if(sum1 == sum2) {
			return sum1;
		}
		return -1;
	}
	public boolean isMagicSquare(int[][] grid, int r, int c) {
		int rowsum=findRowSum(grid,r,c);
		if(rowsum==-1) {
			return false;
		}
		int colsum = findColSum(grid,r,c);
		if(colsum==-1) {
			return false;
		}

		int diagonal = diagonalSum(grid, r,c);
		if(diagonal == -1) {
			return false;
		}
		if(rowsum==colsum && rowsum==diagonal) {
			return true;
		}
		return false;
	}
	public int numMagicSquaresInside(int[][] grid) {

		int row = grid.length;
		int col = grid[0].length;
		//base case
		if(row < 3 || col <3) {
			return 0;
		}
		int count=0;
		for(int i=0; i<row-2; i++) {
			for(int j=0; j<col-2; j++) {
				if(isMagicSquare(grid,i,j)) {
					count++;
				}
			}
		}
		return count;
	}
}