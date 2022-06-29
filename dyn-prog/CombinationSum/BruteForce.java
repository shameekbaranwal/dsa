import java.util.*;

class BruteForce {
	public static Map<Integer, List<List<Integer>>> map;

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		map = new HashMap<Integer, List<List<Integer>>>();
		Arrays.sort(candidates);
		return combinationSumDP(candidates, target);
	}

	public static List<List<Integer>> combinationSumDP(int[] candidates, int target) {
		if (target == 0) {
			List<List<Integer>> l = new ArrayList<List<Integer>>();
			l.add(new ArrayList<Integer>());
			return l;
		}

		if (target < 0 || candidates.length == 0)
			return new ArrayList<List<Integer>>();

		if (target == candidates[0]) {
			List<List<Integer>> l = new ArrayList<List<Integer>>();
			List<Integer> l2 = new ArrayList<Integer>();
			l2.add(target);
			l.add(l2);
			return l;
		}

		List<List<Integer>> l1 = combinationSum(candidates, target - candidates[0]);
		for (int i = 0; i < l1.size(); i++)
			l1.get(i).add(candidates[0]);

		int[] newCandidates = new int[candidates.length - 1];
		System.arraycopy(candidates, 1, newCandidates, 0, candidates.length - 1);
		List<List<Integer>> l2 = combinationSum(newCandidates, target);
		l1.addAll(l2);

		return l1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 6, 7 };
		System.out.println(combinationSum(arr, 7));
	}
}