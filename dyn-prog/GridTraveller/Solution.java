package GridTraveller;

/*
 * Say that you are a traveller on a 2D grid.
 * You begin in the top-left corner, and your goal is to travel to the
 * bottom-right corner.
 * You may only move down or right.
 * 
 * In how many ways can you travel to the goal on a grid with dimensions m * n?
 * 
 * Write a function gridTraveller(m, n) that calculates this.
 */

public class Solution {
	long[][] grid;

	long gridTraveller(int m, int n) {
		if (m <= 0 || n <= 0)
			return 0;
		if (m == 1 || n == 1)
			return 1;

		if (grid[m][n] > 0)
			return grid[m][n];
		if (grid[n][m] > 0)
			return grid[n][m];

		grid[m][n] = gridTraveller(m - 1, n) + gridTraveller(m, n - 1);
		grid[n][m] = grid[m][n];

		return grid[m][n];
	}

	public long uniquePaths(int m, int n) {
		int size = Math.max(m, n) + 1;
		grid = new long[size][size];

		return gridTraveller(m, n);
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.uniquePaths(7, 3) == 28);
		System.out.println(obj.uniquePaths(18, 18) == 2333606220l);
	}
}