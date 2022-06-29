/*
 * Write a function `canConstruct(String target, String[] wordBank)`.
 * The function should return a boolean indicating whether or not the `target` can be constructed 
 * by concatenating elements of the `wordBank` array.
 * You may reuse elements of `wordBank` as many times as needed. 
 */

class Solution {

	public boolean canConstruct(String target, String[] wordBank) {
		if (target.length() == 0)
			return true;
		if (wordBank.length == 0)
			return false;

		for (String w : wordBank) {
			int l = Math.min(w.length(), target.length());
			String s = target.substring(0, l);
			if (!s.equals(w))
				continue;
			String remaining = target.substring(l, target.length());

			if (canConstruct(remaining, wordBank))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.canConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
	}
}