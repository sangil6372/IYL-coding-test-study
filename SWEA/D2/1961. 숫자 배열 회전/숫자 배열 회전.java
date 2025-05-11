import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] arr1 = new int[N][N];
			int[][] arr2 = new int[N][N];
			int[][] arr3 = new int[N][N];
//			회전 드가자 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr1[j][N-i-1] = arr[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr2[j][N-i-1] = arr1[i][j];
				}
			}for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr3[j][N-i-1] = arr2[i][j];
				}
			}
			sb.append("#"+ test_case + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr1[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(arr2[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(arr3[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}