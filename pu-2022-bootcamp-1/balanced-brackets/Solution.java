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
	static Stack<Integer> stack;
	/*
	 * Complete the 'isBalanced' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts STRING s as parameter.
	 */

	public static String isBalanced(String s) {
		stack = new Stack<Integer>();
		char[] open = { '(', '[', '{' };
		char[] close = { ')', ']', '}' };

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			boolean flag = false;

			for (int j = 0; j < 3; j++) {
				if (c == open[j]) {
					stack.push(j);
					flag = true;
					break;
				}
			}
			if (flag)
				continue;

			if (stack.isEmpty())
				return "NO";

			int x = stack.pop();
			if (c != close[x])
				return "NO";
		}

		return stack.isEmpty() ? "YES" : "NO";
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				String s = bufferedReader.readLine();

				String result = Result.isBalanced(s);

				bufferedWriter.write(result);
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
