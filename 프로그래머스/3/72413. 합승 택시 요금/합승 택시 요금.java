import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] map = new int[n+1][n+1];
        for (int i = 1; i <= n ; i++){
            Arrays.fill(map[i], 200*10000);
            map[i][i] = 0;
        }
        for (int[] f : fares){
            int start = f[0];
            int end = f[1];
            int w = f[2];
            map[start][end] = w;
            map[end][start] = w;
        }
        
        for (int k = 0 ; k <= n ; k++){
            for (int i = 0 ; i <=n ; i++){
                for (int j = 0 ; j <=n ; j++){
                    if (map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        
        answer = map[s][a] + map[s][b];
        
        for (int i = 0 ; i <= n ; i++){
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }
        
        
        return answer;
    }
}