// better approach than QuickUnion
// we ensure that no excessively long trees emerge
// by keeping track of the length of each individual connected component

public class QuickUnionWeighted {
	int nodes[], sizes[];

	QuickUnionWeighted(int N) {
		nodes = new int[N];
		sizes = new int[N];

		for (int i = 0; i < N; i++) {
			nodes[i] = i;
			sizes[i] = 1;
		}
	}

	private int root(int x) {
		int size = 1;
		while (nodes[x] != x) {
			x = nodes[x];
			size++;
		}
		sizes[x] = size;
		return x;
	}

	// makes "b" a parent of "a".
	private void join(int a, int b) {
		nodes[a] = b;
	}

	// the bigger trees becomes the parent.
	public void union(int a, int b) {
		if (sizes[b] > sizes[a])
			join(root(a), root(b));
		else
			join(root(b), root(a));
	}

	public boolean connected(int a, int b) {
		return root(a) == root(b);
	}
}