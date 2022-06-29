
import java.util.*;

class Solution {
	public static int furthestBuilding(int[] heights, int bricks, int ladders) {
		PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
		int i = 1;
		for (i = 1; i < heights.length; i++) {
			int diff = heights[i] - heights[i - 1];
			if (diff <= 0)
				continue;

			bricks -= diff;
			maxheap.add(diff);

			if (bricks < 0) {
				bricks += maxheap.poll();
				ladders--;
			}

			if (ladders < 0)
				break;
		}

		return --i;
	}

	public static void check(int actual, int expected, int tc) {
		System.out.print("TEST CASE " + tc + "  - ");
		System.out.println(expected == actual ? "PASSED" : "FAILED\nExpected: " + expected + "\nActual: " + actual);
	}

	public static void main(String[] args) {
		check(furthestBuilding(new int[] { 4, 2, 7, 6, 9, 14, 12 }, 5, 1), 4, 1);
		check(furthestBuilding(new int[] { 4, 12, 2, 7, 3, 18, 20, 3, 19 }, 10, 2), 7, 2);
		check(furthestBuilding(new int[] { 14, 3, 19, 3 }, 17, 0), 3, 3);
	}
}