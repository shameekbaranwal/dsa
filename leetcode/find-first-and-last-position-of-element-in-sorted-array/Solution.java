import java.util.ArrayList;

class Solution {
	public int[] searchRange(int[] nums, int target) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i : nums)
			ar.add(i);

		return new int[] { ar.indexOf(target), ar.lastIndexOf(target) };
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] a = obj.searchRange(new int[] { 5, 7, 7, 8, 8, 8 }, 8);
		System.out.println(a[0] + ", " + a[1]);
	}
}