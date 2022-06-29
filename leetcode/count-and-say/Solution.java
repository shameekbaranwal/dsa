class Solution {
	public String countAndSay(int n) {
		if (n == 1)
			return "1";

		String prev = countAndSay(n - 1);
		return say(prev);
	}

	public String say(String s) {
		int len = s.length();
		StringBuilder result = new StringBuilder("");
		int current = s.charAt(0) - '0', count = 1;

		if (len == 1)
			return (count + "" + current);

		for (int i = 1; i < len; i++) {
			int num = s.charAt(i) - '0';

			if (num != current) {
				result.append(count + "" + current);
				current = num;
				count = 0;
			}
			count++;

			if (i == s.length() - 1) {
				result.append(count + "" + current);
				break;
			}
		}

		return result.toString();
	}

	public static void check(String actual, String expected, int tc) {
		System.out.print("TEST CASE " + tc + "  - ");
		System.out
				.println(expected.equals(actual) ? "PASSED" : "FAILED\nExpected: " + expected + "\nActual: " + actual);
	}

	public static void main(String[] args) {
		Solution obj = new Solution();

		check(obj.countAndSay(1), "1", 1);
		check(obj.countAndSay(2), "11", 2);
		check(obj.countAndSay(3), "21", 3);
		check(obj.countAndSay(4), "1211", 4);
	}
}