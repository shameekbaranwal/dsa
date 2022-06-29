import java.util.*;

public class Main {
	static int N;
	static int W;
	static int[] w;
	static long[] v;
	static ArrayList<Map<Long, Long>> list;

	public static long getMaxValue(int i, int accumWeight, long accumValue) {
		if (i >= N)
			return accumValue;
		if (list.get(i).containsKey(accumValue))
			return list.get(i).get(accumValue);

		long v1 = getMaxValue(i + 1, accumWeight, accumValue);
		long v2 = 0;
		if (accumWeight + w[i] <= W)
			v2 = getMaxValue(i + 1, accumWeight + w[i], accumValue + v[i]);

		list.get(i).put(accumValue, Math.max(v1, v2));
		return list.get(i).get(accumValue);

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		W = sc.nextInt();
		w = new int[N];
		v = new long[N];
		list = new ArrayList<Map<Long, Long>>(N);
		for (int i = 0; i < N; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextLong();
			list.add(new HashMap<Long, Long>());
		}
		System.out.println(getMaxValue(0, 0, 0));
		sc.close();
	}
}