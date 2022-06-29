import java.util.*;

class Solution {
	HashSet<String> set;
	String s;
	int len;
	int dp[];

	public boolean wordBreak(String s, List<String> wordDict) {
		// to perform faster dictionary lookups
		set = new HashSet<>(wordDict);
		this.s = s;
		this.len = s.length();

		// keeps track of whether the substring from 'index' to len can be broken into
		// words from dictionary or not. 0 if untouched, 1 if it can, -1 if it can't.
		dp = new int[len + 1];
		dp[len] = 1;

		// using index as the parameter to avoid having to re-evaluate substring at
		// every stage
		// doesn't improve complexity overall but the constants are probably smaller
		return wordBreakRecursive(0);
	}

	public boolean wordBreakRecursive(int index) {
		if (index == len)
			return true;

		if (dp[index] != 0)
			return dp[index] == 1 ? true : false;

		// since the String scan just involves adding a character at every stage
		// then using a StringBuilder is better because appending characters is O(1).
		StringBuilder substr = new StringBuilder("");
		for (int i = index; i < len; i++) {
			substr.append(s.charAt(i));

			// if the ith index has already been evaluated for, then:

			// if it was true, then the current index is valid too, so just return true.
			if (dp[i] == 1) {
				dp[index] = 1;
				return true;
			}

			// if it was false, then no need to lookup in hashmap
			if (dp[i + 1] == -1)
				continue;

			// if ith index is unevaluated, then if current substr is in dictionary,
			// then recursively call the function for the remaining string and check if it
			// returns true.
			if (set.contains(substr.toString())) {
				if (wordBreakRecursive(i + 1)) {
					dp[index] = 1;
					return true;
				}
			}
		}

		dp[index] = -1;
		return false;
	}

	public static void check(boolean actual, boolean expected, int tc) {
		System.out.print("TEST CASE " + tc + "  - ");
		System.out.println(expected == actual ? "PASSED (" + actual + ")"
				: "FAILED\nExpected: " + expected + "\nActual: " + actual);
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		check(obj.wordBreak("applepenapple", List.of("apple", "pen")), true, 1);
		check(obj.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")), false, 2);
	}
}