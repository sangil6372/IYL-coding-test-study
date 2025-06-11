import java.util.*;

class Solution {
    
    List<List<Integer>> graph;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new ArrayList<>();
        for (int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        answer = bfs(n);
        
        return answer;
    }
    
    public int bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        
        boolean[] visited =new boolean[n+1];
        visited[1] = true;
        int cnt  = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            cnt = size;
            
            for (int i = 0 ; i < size ; i++){                
                int curr = queue.poll();
                
                for (int next : graph.get(curr)){
                    if (!visited[next]){
                        visited[next] = true;
                        queue.offer(next);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    
}