import java.util.Scanner;

public class Main {

	
	
	static long mod = 1000000000;
	static int N;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		
		long dp[][] = new long[N+1][10];
		
		//기본 N == 1 
		for (int j=1;j<10;j++) {
			dp[1][j] = 1;
		}
		
		for (int i = 2;i<=N;i++) {
			for (int j =0;j<10;j++) {
				if (j==0) dp[i][j] = dp[i-1][1]%mod;
				else if (j==9) dp[i][j] = dp[i-1][8]%mod;
				else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;
			}
		}
		
		long ans = 0;
		for (int i =0;i<10;i++) {
			ans += dp[N][i];
		}
		
		System.out.println(ans%mod);
		
		
		
		sc.close();
	}
}