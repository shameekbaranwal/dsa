package HowSum;

/*
	Write a function `howSum(targetSum, numbers[]) that takes in an int targetSum and an int[] numbers as arguments.

	The function should return an array containing any combination of elements that add up to exactly the targetSum.
	If there is no combination that adds up to the targetSum, then return null.
*/
import java.util.*;

class Solution {
	Map<Integer, List<Integer>> map;

	List<Integer> howSum(int targetSum, List<Integer> numbers) {
		if (targetSum == 0)
			return new ArrayList<Integer>();
		if (targetSum < 0)
			return null;
		if (map.containsKey(targetSum))
			return map.get(targetSum);

		for (int num : numbers) {
			List<Integer> child = howSum(targetSum - num, numbers);
			if (child != null) {
				child.add(num);
				map.put(targetSum, child);
				return child;
			}
		}

		map.put(targetSum, null);
		return null;
	}

	List<Integer> howSumDP(int targetSum, List<Integer> numbers) {
		map = new HashMap<Integer, List<Integer>>();
		return howSum(targetSum, numbers);
	}

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(5);
		arr.add(1);
		arr.add(3);
		arr.add(7);

		Solution obj = new Solution();
		System.out.println(obj.howSumDP(7, arr));
	}
}