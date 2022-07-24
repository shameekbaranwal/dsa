import java.io.*;

public class Test {
	public static void main(String[] args) throws IOException {
		FileReader txt = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(txt);

		// First line is the number of nodes
		String line = br.readLine();
		int N = Integer.parseInt(line);
		// QuickFindUF uf = new QuickFindUF(N);
		// QuickUnionUF uf = new QuickUnionUF(N);
		QUWPC uf = new QUWPC(N);
		// Second line is the query pair
		line = br.readLine();
		int[] checks = getNum(line);
		// Further lines are pre-existing nodes
		line = br.readLine();

		while (line != null) {
			int a = getNum(line)[0];
			int b = getNum(line)[1];

			if (!uf.connected(a, b))
				uf.union(a, b);

			line = br.readLine();
		}

		String conn = uf.connected(checks[0], checks[1]) ? "" : "not ";
		System.out.println(checks[0] + " and " + checks[1] + " are " + conn + "connected.");

		br.close();
	}

	public static int[] getNum(String s) {
		String[] s1 = s.split(" ");
		int a = Integer.parseInt(s1[0]);
		int b = Integer.parseInt(s1[1]);
		int[] val = { a, b };
		return val;
	}
}