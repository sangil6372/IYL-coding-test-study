import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visitedDFS;
    static boolean[] visitedBFS;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 정점
        int M = Integer.parseInt(input[1]); // 간선
        int V = Integer.parseInt(input[2]); // 탐색 시작 번호

        graph = new ArrayList<>();
        for (int i = 0; i < N+1 ;i++){
            graph.add(new ArrayList<>());
        }
        visitedDFS = new boolean[N+1];
        visitedBFS = new boolean[N+1];

        while(M-->0){
            input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
//           양방향 노드
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        for (int i = 1 ; i<= N; i++){
            Collections.sort(graph.get(i));
        }

        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }
    public static void dfs(int cur){
        visitedDFS[cur] = true;
        sb.append(cur + " ");

        for (int node : graph.get(cur)){
            if (!visitedDFS[node]){
                dfs(node);  // 굳이 백트래킹 필요 X
            }
        }

    }
    public static void bfs(int cur){
        visitedBFS[cur] = true;
        sb.append(cur+" ");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);

        while(!queue.isEmpty()){
            int peek = queue.poll();

            for (int node : graph.get(peek) ){
                if (!visitedBFS[node]){
                    visitedBFS[node] = true;
                    sb.append(node+" ");
                    queue.add(node);
                }
            }

        }

    }

}

