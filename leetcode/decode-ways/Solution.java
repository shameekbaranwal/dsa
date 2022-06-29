class Solution {
	String s;
	int len;

	public int numDecodings(String s) {
		this.s = s;
		this.len = s.length();
		return numDecodingsDP(0);
	}

	public int numDecodingsDP(int i) {
		if (i >= len)
			return 0;
		if (i == len)
			return 1;
		if (i == len - 1)
			return s.charAt(i) == '0' ? 0 : 1;

		int n = s.charAt(i) - '0';
		int n1 = numDecodingsDP(i + 1);
		if (n == 0)
			return n1;

		int n2 = 0;
		if (n == 1 || (n == 2 && i < (len - 1) && (s.charAt(i + 1) - '0') <= 6))
			n2 = numDecodingsDP(i + 2);

		return (n1 + n2);
	}

	public static void check(int actual, int expected, int tc) {
		System.out.print("TEST CASE " + tc + "  - ");
		System.out.println(expected == actual ? "PASSED" : "FAILED\nExpected: " + expected + "\nActual: " + actual);
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		check(obj.numDecodings("12"), 2, 1);
		check(obj.numDecodings("226"), 3, 2);
		check(obj.numDecodings("06"), 0, 3);
	}
}