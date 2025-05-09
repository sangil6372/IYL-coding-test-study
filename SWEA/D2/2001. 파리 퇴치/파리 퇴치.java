import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxNum = 0;
			for (int i = 0 ; i < N-M+1; i++) {
				for (int j = 0 ; j < N-M+1; j++) {
					int sum = 0;
					for (int k = 0; k < M; k++) {
						for (int x = 0 ; x < M ; x++) {
							sum += arr[i+k][j+x];
						}
					}
					maxNum = Math.max(maxNum, sum);
				}	
			}
			sb.append("#" + test_case + " " + maxNum + "\n");
		}
		System.out.println(sb);
	}
}