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

	/*
	 * Complete the 'largestRectangle' function below.
	 *
	 * The function is expected to return a LONG_INTEGER.
	 * The function accepts INTEGER_ARRAY h as parameter.
	 */

	public static long largestRectangle(List<Integer> h) {
		// Write your code here
		// int x1, x2, minPos = 0;

		// // get min
		// for (int i = 0; i < h.size(); i++)
		// minPos = h.get(i) < h.get(minPos) ? i : minPos;

		// int area1 = h.get(minPos) * h.size();

		// x1 = minPos, x2 = h.size() - 1;
		// for(int i = minPos + 1; i < h.size(); i++) {

		// }

		// Divide n Conquer
		if (h.size() == 0)
			return 0;
		if (h.size() == 1)
			return h.get(0);

		if (h.size() == 2) {
			long a1 = h.get(0);
			long a2 = h.get(1);
			long a3 = Math.min(a1, a2) * 2;
			a3 = Math.max(a1, a3);
			a3 = Math.max(a2, a3);
			return a3;
		}

		List<Integer> h1 = new ArrayList<Integer>();
		List<Integer> h2 = new ArrayList<Integer>();
		for (int i = 0; i < h.size() / 2; i++)
			h1.add(h.get(i));
		for (int i = h.size() / 2; i < h.size(); i++)
			h2.add(h.get(i));

		long a1 = largestRectangle(h1);
		long a2 = largestRectangle(h2);

		int maxPos1 = h1.size() - 1;
		int min1 = h1.get(maxPos1);
		long a31 = min1;
		for (int i = h1.size() - 2; i >= 0; i--) {
			int val = h1.get(i);
			min1 = Math.min(min1, val);
			int sz = h1.size() - i;
			if (sz * min1 > a31) {
				a31 = sz * min1;
				maxPos1 = i;
			}
		}

		int maxPos2 = 0;
		int min2 = h2.get(maxPos2);
		long a32 = min2;
		for (int i = 0; i < h2.size(); i++) {
			int val = h2.get(i);
			min2 = Math.min(min2, val);
			int sz = i + 1;
			if (sz * min2 > a32) {
				a32 = sz * min1;
				maxPos2 = i;
			}
		}

		int min = min1;
		long a3 = 0;
		if (min1 < min2) {
			for (int i = maxPos2 + 1; i < h2.size(); i++) {
				int val = h2.get(i);
				if (val < min)
					maxPos2 = i - 1;cd ..
					
			}
		} else if (min1 > min2) {
			min = min2;
			for (int i = maxPos1 - 1; i >= 0; i--) {
				int val = h1.get(i);
				if (val < min)
					maxPos1 = i + 1;
			}
		}
		int sz = (maxPos2 + h1.size()) - maxPos1 + 1;
		a3 = min * sz;

		long max = Math.max(a1, a2);
		max = Math.max(max, a3);

		return max;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		long result = Result.largestRectangle(h);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
