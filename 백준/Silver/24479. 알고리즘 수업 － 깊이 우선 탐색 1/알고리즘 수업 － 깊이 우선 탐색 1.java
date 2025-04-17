import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    static List<List<Integer>> graph;
    static int order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        visited = new int[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 작은 정점부터 방문하도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        order = 1;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void dfs(int cur) {
        visited[cur] = order++;

        for (int next : graph.get(cur)) {
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }


}
