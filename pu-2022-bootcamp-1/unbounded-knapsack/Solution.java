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
	public static Map<Integer, Boolean> map;

	public static int unboundedKnapsack(int k, List<Integer> arr) {
		// Write your code here
		for (int i = k; i > 0; i--) {
			if (canSum(i, arr))
				return i;
		}
		return 0;
	}

	public static boolean canSum(int k, List<Integer> arr) {
		map = new HashMap<Integer, Boolean>();
		return canSumDP(k, arr);
	}

	public static boolean canSumDP(int k, List<Integer> arr) {
		if (k < 0)
			return false;
		if (k == 0)
			return true;
		if (arr.size() == 0)
			return false;
		if (map.containsKey(k))
			return map.get(k);

		for (int i = 0; i < arr.size(); i++) {
			int n = arr.get(i);
			if (canSumDP(k - n, arr)) {
				map.put(k, true);
				return true;
			}
		}

		map.put(k, false);
		return false;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		while (t-- > 0) {
			String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			int n = Integer.parseInt(firstMultipleInput[0]);

			int k = Integer.parseInt(firstMultipleInput[1]);

			List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
					.map(Integer::parseInt)
					.collect(toList());

			int result = Result.unboundedKnapsack(k, arr);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedReader.close();
		bufferedWriter.close();
	}
}
