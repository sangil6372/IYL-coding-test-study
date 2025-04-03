class Solution {
    static long MOD = 1234567;
    static long[] dp;
    public long solution(int n) {
        
        dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;

        return fibo(n);
    }
    
//   dp[n] = dp[n-1] + dp[n-2]
    public static long fibo(int n){
        if (dp[n] != 0) return dp[n];
        return dp[n] = (fibo(n-1) + fibo(n-2))%MOD;
    }

}