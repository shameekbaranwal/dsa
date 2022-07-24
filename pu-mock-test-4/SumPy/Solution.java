import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.*;
import java.util.StringTokenizer;

public class Solution {
	static int L, R;
	static int n;
	// static int[] sumOfFactors;
	static long sum;

	// x + Factor < n
	public static void findSumOfFactors() {

		for (int i = 1; i <= R; i++) {
			int remainder = R % i;
			int maxInRange = R - remainder;
			if (maxInRange < L)
				continue;
			int numsInRange = maxInRange - L;
			int multiples = (numsInRange / i) + 1;
			sum += i * multiples;
		}
	}

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			n = R - L + 1;
			sum = 0;
			findSumOfFactors();
			System.out.println(sum);
		}

		// sc.close();
	}
}