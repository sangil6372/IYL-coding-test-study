import java.util.*;

class Solution {
   
    public class Node {
        int end, cost;
        
        public Node (int end, int cost){
            this.end = end;
            this.cost = cost;
        }
        
    }
    int[] dist;
    List<List<Node>> graph;
    int INF = Integer.MAX_VALUE;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
    
        dist = new int[N+1];
        graph = new ArrayList<>();
        
        Arrays.fill(dist, INF);
        for (int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road){
            int s = r[0];
            int e = r[1];
            int w = r[2];
            
            graph.get(s).add(new Node(e,w));
            graph.get(e).add(new Node(s,w));
        }    
        dijkstra(1);
        
        for (int d : dist){
            if (d <= K) answer++;

        }
        
        
        return answer;
    }
    
   
    public void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)-> n1.cost-n2.cost);
        pq.offer(new Node(start,0));
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            for (Node next : graph.get(cur.end)){
                int newCost = cur.cost + next.cost;
                if (newCost < dist[next.end]){
                    dist[next.end] = newCost;
                    pq.offer(new Node(next.end, newCost));
                }
                
            }
            
            
        }
        
        
        
    }
    
    
    
}