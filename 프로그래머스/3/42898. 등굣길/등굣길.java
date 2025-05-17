class Solution {
    final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
//      최단 경로 ..? BFS ? 그래도 DP 로 접근해보자잉
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
//        웅덩이는 -1 로 체크 
        for (int[] puddle : puddles){
            dp[puddle[1]][puddle[0]] = -1; 
        }
        for (int i = 1 ; i <= n ; i++){
            for (int j = 1; j <= m ; j++){
                if (i==1 && j==1) continue;
//              웅덩이는 0으로 만드록 패스 
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = (dp[i - 1][j]% MOD + dp[i][j - 1]% MOD) % MOD;
            }
        }
        answer = dp[n][m];
        
        return answer;
    }
}