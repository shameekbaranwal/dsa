import java.util.*;

class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();

		if (numRows == 0)
			return l;

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l.add(l1);

		for (int i = 1; i < numRows; i++) {
			List<Integer> ll = new ArrayList<Integer>();
			List<Integer> prev = l.get(i - 1);
			ll.add(1);

			for (int j = 0; j < i - 1; j++)
				ll.add(prev.get(j) + prev.get(j + 1));

			ll.add(1);

			l.add(ll);
		}

		return l;
	}
}