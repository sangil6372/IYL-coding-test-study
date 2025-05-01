import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		dp = new int[11];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
	
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(recur(n)+"\n");
		}
		System.out.println(sb);
	}

	static int recur(int i) {
		if (dp[i] > 0)
			return dp[i];
		dp[i] = recur(i-1) + recur(i-2) + recur(i-3);
		return dp[i];
	}
}
