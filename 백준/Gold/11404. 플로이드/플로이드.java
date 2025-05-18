import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int[][] dist;
    static int[][] graph;
																																										
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 정점 개수 V, 간선 개수 E 입력
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(br.readLine());

        graph = new int[V+1][V+1];
		dist = new int[V+1][V + 1];  // 최단 거리 배열 초기화 (모든 거리 무한대로 설정)
        // 인접 행렬 초기화
        for (int i = 1; i < V + 1; i++) {
            Arrays.fill(graph[i], INF);
			Arrays.fill(dist[i], INF);			
        }

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
            // 더 짧을 경우에만 갱신 ㄱㄱ
			if (graph[s][e] > w){
                graph[s][e] = w;
            }
		}
						
		for (int i = 1 ; i <= V ; i++) {
			dijkstra(i, V);  // 다익스트라 알고리즘 실행			
		}
		
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <=V ; j++) {
				if (dist[i][j]==INF)sb.append("0 ");
				else sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
																																										
	static void dijkstra(int start, int V) {
	  // 👆거리 오름차순 정렬 
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
		pq.offer(new int[] { start, 0 }); // 1️⃣ 출발 노드 설정한다.
		dist[start][start] = 0; // 출발 노드 거리는 0

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();  // 2️⃣ 최단 거리 노드 정보 추출
			int currNode = curr[0];
			int currDist = curr[1];

			if (currDist != dist[start][currNode])  // 갱신된 거리가 아니면 방문한 노드임! 
					continue;

			for (int i = 1; i<= V; i++){
                // 경로 없으면 스킵
                if (graph[currNode][i] == INF) continue; 
                
                int newDist = currDist + graph[currNode][i];
                if (dist[start][i] > newDist){
                    dist[start][i] = newDist;
                    pq.offer(new int[]{i,newDist}); // (갱신된 거리, 노드)로 저장 
                }
                   
            }
		}
	}
}