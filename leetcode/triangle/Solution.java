import java.util.*;

class Solution {
	static List<List<Integer>> triangle;
	static int rows;
	static int[][] dp;

	public static int minimumTotal(List<List<Integer>> tr) {
		triangle = tr;
		rows = tr.size();
		dp = new int[rows + 1][rows + 1];
		for (int i = 0; i < rows; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		Arrays.fill(dp[rows], 0);
		return minTot(0, 0);
	}

	public static int minTot(int row, int index) {
		if (row == rows)
			return 0;
		if (dp[row][index] != Integer.MAX_VALUE)
			return dp[row][index];

		int s1 = dp[row + 1][index];
		if (s1 == Integer.MAX_VALUE)
			s1 = minTot(row + 1, index);

		int s2 = dp[row + 1][index + 1];
		if (s2 == Integer.MAX_VALUE)
			s2 = minTot(row + 1, index + 1);

		int min = Math.min(s1, s2);

		return triangle.get(row).get(index) + min;
	}

	public static void assertEquals(

			int actual,
			int expected,
			int tc) {
		System.out.print("TEST CASE " + tc + "  - ");
		System.out.println(expected == actual ? "PASSED (" + actual + ")"
				: "FAILED\nExpected: " + expected + "\nActual: " + actual);
	}

	public static void main(String[] args) {
		assertEquals(minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5,
				7),
				List.of(4, 1, 8, 3))), 11, 1);
		assertEquals(minimumTotal(List.of(List.of(-10))), -10, 2);
	}
}