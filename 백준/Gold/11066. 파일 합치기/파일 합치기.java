import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			int[] sum = new int[K]; // 누적합
			int[] files = new int[K];
			int[][] dp = new int[K][K];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				files[i] = Integer.parseInt(st.nextToken());
				if (i == 0)
					sum[i] = files[i];
				else
					sum[i] = sum[i - 1] + files[i];
			}
			for (int len = 2; len <= K; len++) {
				for (int start = 0; start + len <= K; start++) {
					int end = start + len - 1;
					dp[start][end] = Integer.MAX_VALUE;
					for (int i = start; i < end; i++) {
						int cost = sum[end];
						if (start != 0)
							cost = sum[end] - sum[start - 1];
						dp[start][end] = Math.min(dp[start][end], dp[start][i] + dp[i + 1][end] + cost);

					}
				}
			}
			sb.append(dp[0][K - 1] + "\n");
		}
		System.out.println(sb);
	}

}
