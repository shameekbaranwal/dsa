// best possible approach than QuickUnion
// as we iterate up the tree from some node
// we flatten the tree out.
// The complexity becomes M + N.log*(N),
// where log*(N) is the iterative log function
// which is almost linear.

public class QUWPC {
	int nodes[], sizes[];

	QUWPC(int N) {
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
			nodes[x] = nodes[nodes[x]];
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