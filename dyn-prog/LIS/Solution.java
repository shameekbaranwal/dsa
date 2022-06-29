
public class Solution {
	public int LIS(int[] arr, int k) {
		int max = 0;

		for (int i = 0; i < k; i++) {
			int val = LIS(arr, i);
			max = Math.max(max, val);
		}

		return max + 1;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.LIS(new int[] { 5, 2, 8, 6, 3, 6, 9, 5 }, 7));
		// System.out.println(obj.LIS(new int[] { 5, 2, 8 }, 2));
	}
}
