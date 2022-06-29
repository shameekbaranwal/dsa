import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] dp;

	public static int getMaxHappiness(int i, int skip) {
		if (i >= N)
			return 0;
		if (skip != -1 && dp[i][skip] != -1)
			return dp[i][skip];

		int max = Integer.MIN_VALUE;
		for (int j = 0; j < 3; j++) {
			if (j == skip)
				continue;
			max = Math.max(max, arr[i][j] + getMaxHappiness(i + 1, j));
		}

		if (skip == -1)
			skip = 0;
		dp[i][skip] = max;
		return max;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();

			dp[i][0] = -1;
			dp[i][1] = -1;
			dp[i][2] = -1;
		}
		System.out.println(getMaxHappiness(0, -1));
		sc.close();
	}
}