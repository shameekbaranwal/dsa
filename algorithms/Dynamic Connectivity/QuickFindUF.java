// eager approach
// constant time for find
// quadratic time for union

// trees are maintained flat, but that can be expensive

public class QuickFindUF {
	private int N, nodes[];

	public QuickFindUF(int N) {
		nodes = new int[N];
		this.N = N;
		for (int i = 0; i < N; i++)
			nodes[i] = i;

	}

	public void union(int a, int b) {
		int prev = nodes[b];
		for (int i = 0; i < N; i++)
			if (nodes[i] == prev)
				nodes[i] = nodes[a];

	}

	public boolean connected(int a, int b) {
		return (nodes[a] == nodes[b]);
	}

}
