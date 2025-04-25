import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        graph = new ArrayList<>();
        visited = new boolean[n+1];
        
        for (int i = 0; i <= n; i++ ){
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n ; i++){
            for (int j = 0;  j < n ; j++){
                if (computers[i][j] == 1){
                    graph.get(i+1).add(j+1);
                    graph.get(j+1).add(i+1);
                }
            }
        }
        for (int i = 1 ; i <= n; i++){
            graph.get(i).add(i);
        }
        
        
        for (int i = 1; i <= n ; i++){
            if (!visited[i]){
                answer++;
                dfs(i);
            }
        }
        
        
        return answer;
    }
    
    public static void dfs(int cur){
        visited[cur] = true;
        
        for (int n : graph.get(cur)){
            if (!visited[n]) dfs(n);
        }    
    }
    
}