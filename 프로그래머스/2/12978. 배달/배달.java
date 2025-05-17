import java.util.*;

class Solution {
    static int[][] graph;
    static int[] dist;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new int[N+1][N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];
        // 인접 행렬 초기화
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(graph[i], INF);
        }
        // 그래프 입력
        for (int[] r : road){
            int s = r[0];
            int e = r[1];
            int w = r[2];
            // 더 짧을 경우에만 갱신 ㄱㄱ
            if (graph[s][e] > w){
                graph[s][e] = w;
                graph[e][s] = w;
            }
        }
        // 최종 거리 초기화 
        Arrays.fill(dist, INF);
        dist[1] = 0;  // 시작점 거리 0
       
        dijkstra(N);
        
        for (int i = 1 ; i <= N; i++){
            if (dist[i] <= K) answer++;
        }
            
        return answer;
    }
    
    
    static void dijkstra(int N){
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2)->n1[0]-n2[0]);
        pq.offer(new int[]{0,1}); // (거리, 노드) 형태로 저장
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currDist = curr[0];
            int node = curr[1];
            
            if (visited[node]) continue; // 방문했으면 skip
            visited[node] = true;
            
            for (int i = 1; i<= N; i++){
                // 경로 없거나 이미 방문했으면 스킵
                if (graph[node][i] == INF || visited[i]) continue; 
                
                int newDist = currDist + graph[node][i];
                if (dist[i] > newDist){
                    dist[i] = newDist;
                    pq.offer(new int[]{newDist,i}); // (갱신된 거리, 노드)로 저장 
                }
                   
                
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}