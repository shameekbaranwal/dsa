class Solution {
	boolean[] dp;

	public static boolean canJump(int[] nums) {
		int maxReached = 0;

		for (int i = 0; i < nums.length; i++) {
			if (maxReached < i)
				return false;
			maxReached = Math.max(maxReached, i + nums[i]);
		}
		return true;
	}

	public static void check(boolean actual, boolean expected, int tc) {
		System.out.print("TEST CASE " + tc + "  - ");
		System.out.println(expected == actual ? "PASSED" : "FAILED\nExpected: " + expected + "\nActual: " + actual);
	}

	public static void main(String[] args) {
		check(canJump(new int[] { 2, 3, 1, 1, 4 }), true, 1);
		check(canJump(new int[] { 3, 2, 1, 0, 4 }), false, 2);
	}
}