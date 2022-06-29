import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
	static Map<Long, Map<Integer, Long>> map;
	/*
	 * Complete the 'getWays' function below.
	 *
	 * The function is expected to return a LONG_INTEGER.
	 * The function accepts following parameters:
	 * 1. INTEGER n
	 * 2. LONG_INTEGER_ARRAY c
	 */

	public static long getWays(int n, List<Long> c) {
		// Write your code here
		map = new HashMap<Long, Map<Integer, Long>>();
		return getWaysDP(n, c);
	}

	public static long getWaysDP(long n, List<Long> c) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (c.size() == 0)
			return 0;
		if (map.containsKey(n) && map.get(n).containsKey(c.size()))
			return map.get(n).get(c.size());

		long total = 0;
		long coin = c.get(0);

		total += getWaysDP(n - coin, c);
		List<Long> c2 = new ArrayList<Long>();
		c2.addAll(c);
		c2.remove(0);
		total += getWaysDP(n, c2);

		if (!map.containsKey(n)) {
			Map<Integer, Long> m = new HashMap<Integer, Long>();
			map.put(n, m);
		}
		map.get(n).put(c.size(), total);
		return total;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Long::parseLong)
				.collect(toList());

		// Print the number of ways of making change for 'n' units using coins having
		// the values given by 'c'

		long ways = Result.getWays(n, c);

		bufferedWriter.write(String.valueOf(ways));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
