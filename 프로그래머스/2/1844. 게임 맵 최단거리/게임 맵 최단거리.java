import java.util.*;

class Solution {
    
    static int[] distX = {0,1,0,-1};
    static int[] distY = {1,0,-1,0};
    static boolean[][] visited;
    static int n,m;
    public int solution(int[][] maps) {
        int answer;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        answer = bfs(maps);
        
        return answer;
    }
    public static int bfs (int[][] maps){

//      일단 현재 상태 저장 
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        visited[0][0] = true;
        
        int depth = 1;
        while(!queue.isEmpty()){
//          레벨 단위 탐색
            int size = queue.size();
            
            for (int i = 0 ; i < size; i++){
                
                int[] peek = queue.poll();
                int curX = peek[0];
                int curY = peek[1];
                
                if (curX == n-1 && curY == m-1) return depth;
                
                for (int j = 0; j < 4; j++){
                    int nextX = curX + distX[j];
                    int nextY = curY + distY[j];
                    if (nextX>=0&&nextY>=0&&nextX<n&&nextY<m){
                        if (!visited[nextX][nextY]&&maps[nextX][nextY]==1){
                            visited[nextX][nextY] = true;
                            queue.add(new int[] {nextX, nextY});
                        }
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}