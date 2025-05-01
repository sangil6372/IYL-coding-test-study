
import java.util.Scanner;

public class Main {

	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
	
		while(T-- > 0) {
			int n = sc.nextInt();
			recur(n);
			System.out.println(dp[n]);
		}
		
		
		
		
		sc.close();
	}

	static int recur(int n) {
		if (dp[n]>0) return dp[n];
		else dp[n] = recur(n-1) + recur(n-2) + recur(n-3);
		
		
		return dp[n];
	}
	
}
