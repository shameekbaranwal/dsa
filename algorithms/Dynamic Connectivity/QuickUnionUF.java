// lazy approach
// constant time for union
// quadratic time for find

// trees can get too tall
// find becomes too expensive, could be N array accesses

public class QuickUnionUF {
	int nodes[];

	public QuickUnionUF(int N) {
		nodes = new int[N];
		for (int i = 0; i < nodes.length; i++)
			nodes[i] = i;
	}

	private int getRoot(int x) {
		return x == nodes[x] ? x : getRoot(nodes[x]);
	}

	public void union(int a, int b) {
		nodes[getRoot(a)] = getRoot(b);
	}

	public boolean connected(int a, int b) {
		return getRoot(a) == getRoot(b);
	}
}