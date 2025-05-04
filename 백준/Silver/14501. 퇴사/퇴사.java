import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] T = new int[N + 2];
		int[] P = new int[N + 2];
		int[] dp = new int[N + 2]; // i일 최대 이익

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			// 상담 O
			int nextDay = i + T[i];
			if (nextDay <= N + 1) {
				dp[nextDay] = Math.max(dp[nextDay], dp[i] + P[i]);
			}
			// 상담 X
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[N+1]);
	}

}
