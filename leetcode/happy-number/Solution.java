import java.util.*;

// Detect Cycle using HashSet
class Solution {
	Set<Integer> arr;

	public boolean isHappy(int n) {
		arr = new HashSet<Integer>();
		return isHappyRec(n);
	}

	public boolean isHappyRec(int n) {
		if (n == 1)
			return true;

		if (arr.contains(n))
			return false;

		arr.add(n);

		int s = 0;
		while (n != 0) {
			int d = n % 10;
			s += d * d;
			n /= 10;
		}
		return isHappyRec(s);
	}
}