class Solution {
	public void gameOfLife(int[][] board) {
		int rows = board.length;
		int columns = board[0].length;
		boolean[][] changed = new boolean[rows][columns];

		int[][] neighbours = {
				{ -1, -1 },
				{ -1, 0 },
				{ -1, 1 },
				{ 0, -1 },
				{ 0, 1 },
				{ 1, -1 },
				{ 1, 0 },
				{ 1, 1 }
		};

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int neighboursAlive = 0;
				for (int k = 0; k < 8; k++) {
					int newi = i + neighbours[k][0];
					int newj = j + neighbours[k][1];
					if (newi >= 0 && newi < rows && newj >= 0 && newj < columns)
						neighboursAlive += changed[newi][newj] ? 1 - board[newi][newj] : board[newi][newj];
				}
				if ((board[i][j] == 0 && neighboursAlive == 3) ||
						(board[i][j] == 1 &&
								(neighboursAlive < 2 || neighboursAlive > 3))) {
					board[i][j] = 1 - board[i][j];
					changed[i][j] = true;
				}
			}
		}
	}
}