import java.io.*;
import java.util.*;

public class Main {
    static int N;                 // 사람 수
    static int[][] graph;            // 능력치 배열
    static boolean[] visited;    // A팀 구성 여부
    static int minDiff = Integer.MAX_VALUE;  // 최소 능력치 차이

    public static void main(String[] args) throws IOException   {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        graph = new int[N][N];
        visited = new boolean[N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }        	

        dfs(0, 0);

        System.out.println(minDiff);
    }

    static void dfs(int depth, int start) {
        if (depth == N / 2) {
            calDiff();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;  // 백트래킹
            }
        }
    }

    static void calDiff() {
        int aSum = 0; 
        int bSum = 0;  

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    aSum += graph[i][j] + graph[j][i];
                } else if (!visited[i] && !visited[j]) {
                    bSum += graph[i][j] + graph[j][i];
                }
            }
        }

        int diff = Math.abs(aSum - bSum);

        minDiff = Math.min(minDiff, diff);

        if (minDiff == 0) {
            System.out.println(0);
            System.exit(0); 
        }
    }
}
