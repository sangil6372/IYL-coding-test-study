import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int dfsCnt;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] wire : wires){
            int n1 = wire[0];
            int n2 = wire[1];
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
//      그래프 세팅 끝
//      하나씩 전부 끊어볼까? 
        for (int[] wire : wires){
            int n1 = wire[0];
            int n2 = wire[1];
            graph.get(n1).remove(Integer.valueOf(n2));
            graph.get(n2).remove(Integer.valueOf(n1));

//          개수 체크 
            visited = new boolean[n+1];
            dfsCnt = 0;
            dfs(1);
            answer = Math.min(answer, Math.abs((n-dfsCnt)-dfsCnt));
            
//          원상 복구 
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        
        
        return answer;
    }
    public static void dfs(int cur){
        visited[cur] = true;
        dfsCnt++;
        for (int n : graph.get(cur)){
            if (!visited[n]){
                dfs(n);
            }
        }
        
        
    }
    
    
    
}