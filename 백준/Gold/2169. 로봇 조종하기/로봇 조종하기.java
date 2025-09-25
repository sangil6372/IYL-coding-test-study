import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 번째 행 초기화 (왼쪽에서만 올 수 있음)
        dp[1][1] = map[1][1];
        for (int j = 2; j <= M; j++) {
            dp[1][j] = dp[1][j-1] + map[1][j];
        }

        // 2행부터 N행까지
        for (int i = 2; i <= N; i++) {
            int[] leftToRight = new int[M+1];
            int[] rightToLeft = new int[M+1];

            // 왼쪽 → 오른쪽 스캔
            leftToRight[1] = dp[i-1][1] + map[i][1];
            for (int j = 2; j <= M; j++) {
                leftToRight[j] = Math.max(leftToRight[j-1], dp[i-1][j]) + map[i][j];
            }

            // 오른쪽 → 왼쪽 스캔
            rightToLeft[M] = dp[i-1][M] + map[i][M];
            for (int j = M-1; j >= 1; j--) {
                rightToLeft[j] = Math.max(rightToLeft[j+1], dp[i-1][j]) + map[i][j];
            }

            // 두 방향 중 최댓값 선택
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(leftToRight[j], rightToLeft[j]);
            }
        }

        // 정답 출력
        System.out.println(dp[N][M]);
    }
}
