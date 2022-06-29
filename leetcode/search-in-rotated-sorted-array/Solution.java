class Solution {
	public int getPivot(int[] nums) {
		int l = 0, h = nums.length - 1, mid = (l + h) / 2;
		while (l < h - 1) {
			mid = (l + h) / 2;
			if (nums[l] > nums[mid]) {
				h = mid;
				continue;
			}
			if (nums[mid] > nums[h]) {
				l = mid;
				continue;
			}
		}
		return mid;
	}

	public int search(int[] nums, int target) {
		int p = getPivot(nums);

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.getPivot(new int[] { 4, 5, 6, 7, 0, 1, 2, 3 }));
	}
}