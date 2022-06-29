package CanSum;

/* 
Write a function canSum(targetSum, numbers) that takes in a target sum value and an array of integers as arguments.
The function should return a boolean indicating whether or not it is possible to generate the targetSum using the numbers from the array.

You may use an element of the array as many times as needed.

You may assume that all input numbers are non-negative.
*/

import java.util.*;

public class Solution {
	Map<Integer, Boolean> arr;

	public boolean canSum(int targetSum, int[] numbers) {
		if (targetSum < 0)
			return false;

		if (targetSum == 0)
			return true;

		if (arr.containsKey(targetSum))
			return arr.get(targetSum);

		for (int num : numbers) {
			if (canSum(targetSum - num, numbers)) {
				arr.put(targetSum, true);
				return true;
			}
		}

		arr.put(targetSum, false);
		return false;
	}

	public boolean canSumDP(int targetSum, int[] numbers) {
		arr = new HashMap<Integer, Boolean>();
		return canSum(targetSum, numbers);

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.canSumDP(5, new int[] { 2, 1 }));
	}
}
