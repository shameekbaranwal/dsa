import java.util.*;

public class Solution {
	static int[] T;
	static List<List<Integer>> paths;
	static int N;

	public static int numOfWaysOut(int currentNode, int K) {
		int s = paths.get(currentNode).size();
		if (s == 0)
			return 1;
		if (K <= 0)
			return 0;

		int total = 0;
		for (int i = 0; i < s; i++) {
			int node = paths.get(currentNode).get(i);
			total += numOfWaysOut(node, K - T[node]);
		}

		return total;
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int K = sc.nextInt();
		T = new int[N];
		for (int i = 0; i < N; i++)
			T[i] = sc.nextInt();

		paths = new ArrayList<List<Integer>>();
		for (int i = 0; i < N; i++) {
			paths.add(new ArrayList<>());
		}
		for (int i = 0; i < N - 1; i++) {
			int X = sc.nextInt() - 1;
			int Y = sc.nextInt() - 1;
			paths.get(X).add(Y);
			// paths.get(Y).add(X);
		}

		System.out.println(numOfWaysOut(0, K));
		sc.close();
	}
}