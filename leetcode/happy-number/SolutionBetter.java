import java.util.*;

// Detect Cycle using two pointers
class Solution {
	public boolean isHappy(int n) {
		int n1 = n;
		int n2 = n;
		while (true) {
			int s1 = sqSum(n1);
			int ss1 = sqSum(s1);
			if (ss1 == 1)
				return true;

			n1 = s1;

			int s2 = sqSum(n2);
			int ss2 = sqSum(n2);
			if (ss2 == 1)
				return true;

			n2 = ss2;

			if (n1 == n2)
				return false;
		}
	}

	public int sqSum(int n) {
		int s = 0;
		while (n != 0) {
			int d = n % 10;
			s += d * d;
			n /= 10;
		}
		return s;
	}

}