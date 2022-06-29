package BestSum;

/*
 * Write a function `bestSum(int targetSum, int[] numbers)`.
 * 
 * This function should return an array containing the shortest combination of
 * numbers that add up to exactly the targetSum.
 */

import java.util.*;

class Solution {
	Map<Integer, List<Integer>> map;

	List<Integer> bestSumDP(int targetSum, int[] numbers) {
		if (targetSum < 0)
			return null;
		if (targetSum == 0)
			return new LinkedList<Integer>();
		if (map.containsKey(targetSum))
			return map.get(targetSum);

		List<Integer> smallestList = null;
		for (int num : numbers) {
			List<Integer> l = bestSumDP(targetSum - num, numbers);
			if (l != null) {
				l.add(num);
				if (smallestList == null || (smallestList != null && smallestList.size() > l.size()))
					smallestList = l;
			}
		}

		map.put(targetSum, smallestList);
		return smallestList;
	}

	List<Integer> bestSum(int targetSum, int[] numbers) {
		map = new HashMap<Integer, List<Integer>>();
		return bestSumDP(targetSum, numbers);
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.bestSum(8, new int[] { 2, 3, 6, 7 }));
	}
}