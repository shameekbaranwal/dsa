import java.util.*;

class Main {
	static int n;
	static int k;
	static int[] h;
	static int[] dp;

	public static int minCost(int i) {
		if (i >= n - 1)
			return 0;
		if (i == n - 2)
			return Math.abs(h[n - 1] - h[n - 2]);
		if (dp[i] != -1)
			return dp[i];

		int ksafe = Math.min(k, n - i - 1);
		int c = Integer.MAX_VALUE;
		for (int j = 1; j <= ksafe; j++) {
			int c1 = Math.abs(h[i] - h[i + j]) + minCost(i + j);
			c = Math.min(c, c1);
		}

		dp[i] = c;
		return c;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		h = new int[n];
		for (int i = 0; i < n; i++)
			h[i] = sc.nextInt();
		dp = new int[n];
		Arrays.fill(dp, -1);
		System.out.println(minCost(0));
		sc.close();
	}
}