
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][3];
		
		// 초기 값 입력
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (N>0) {
			dp[N-1][0] += Math.min(dp[N][2], dp[N][1]);
			dp[N-1][1] += Math.min(dp[N][2], dp[N][0]);
			dp[N-1][2] += Math.min(dp[N][0], dp[N][1]);
			N--;
		}
		System.out.println(Math.min(dp[1][0],Math.min(dp[1][1],dp[1][2])));

	}

}
