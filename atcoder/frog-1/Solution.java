import java.util.*;

class Solution {
	static int n;
	static int[] h;
	static Map<Integer, Integer> map;

	public static int minCost(int i) {
		if (i == n - 1)
			return 0;
		if (i == n - 2)
			return Math.abs(h[n - 1] - h[n - 2]);
		if (map.containsKey(i))
			return map.get(i);

		int c1 = Math.abs(h[i] - h[i + 1]) + minCost(i + 1);
		int c2 = Math.abs(h[i] - h[i + 2]) + minCost(i + 2);

		int c = Math.min(c1, c2);
		map.put(i, c);
		return c;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		h = new int[n];
		for (int i = 0; i < n; i++)
			h[i] = sc.nextInt();
		map = new HashMap<Integer, Integer>();
		System.out.println(minCost(0));
		sc.close();
	}
}