class Solution {
    static long MOD = 1234567;
    static long[] dp;
    public int solution(int n) {
        int answer = 0;
        
        dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        answer = (int)fibo(n);
        
        return answer;
    }
    
    static long fibo(int n) {
        if (dp[n]!=0||n==0||n==1) return dp[n];
        dp[n] = (fibo(n-1)%MOD + fibo(n-2)%MOD)%MOD;
        return dp[n];
    }
}