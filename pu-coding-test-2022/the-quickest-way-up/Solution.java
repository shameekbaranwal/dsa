import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    static ArrayList<List<Integer>> adj;

    /*
     * Complete the 'quickestWayUp' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. 2D_INTEGER_ARRAY ladders
     * 2. 2D_INTEGER_ARRAY snakes
     */

    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
        // Write your code here
        HashMap<Integer, Integer> ld = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> sn = new HashMap<Integer, Integer>();
        for (int i = 0; i < ladders.size(); i++)
            ld.put(ladders.get(i).get(0) - 1, ladders.get(i).get(1) - 1);
        for (int i = 0; i < snakes.size(); i++)
            sn.put(snakes.get(i).get(1) - 1, snakes.get(i).get(0) - 1);

        adj = new ArrayList<List<Integer>>(100);
        for (int i = 0; i < 100; i++) {
            ArrayList<Integer> arr = new ArrayList<Integer>(100);
            // if (ld.containsKey(i) || sn.containsKey(i))
            // continue;
            int j = 1;
            while (j <= 6) {
                int newPos = i + j;
                if (newPos >= 100)
                    break;
                while (true) {
                    if (ld.containsKey(newPos)) {
                        newPos = ld.get(newPos);
                        continue;
                    }
                    if (sn.containsKey(newPos)) {
                        newPos = sn.get(newPos);
                        continue;
                    }
                    break;
                }
                arr.add(newPos);
                j++;
            }
            adj.add(arr);
        }

        return bfs();
    }

    public static int bfs() {
        // Queue<Integer> q = new Q
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[100];
        queue.add(0);
        visited[0] = true;

        List<Integer> l = new ArrayList<>();
        while (queue.size() != 0) {
            int idx = queue.poll();
            // System.out.println(idx + " ");
            l.add(idx);
            for (int i = 0; i < adj.get(idx).size(); i++) {
                int node = adj.get(idx).get(i);
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }

        return l.size();

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> ladders = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        ladders.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int m = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> snakes = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        snakes.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result.quickestWayUp(ladders, snakes);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
