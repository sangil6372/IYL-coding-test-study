import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); // 서류 등수
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, (n1, n2) -> n1[0] - n2[0]); // 서류 기준 정렬 (오름차순)
			// 1등은 패스
			int answer = 1;
			int minScore = arr[0][1]; // 현재 서류가 더 높은 애들 중 최서 면접 성적
			for (int i = 1; i < N; i++) {
				if (arr[i][1] < minScore) {
					answer++;
					minScore = arr[i][1]; // 둘 다 높은 애가 있으면 안되기 때문
				}
			}

			System.out.println(answer);
		}
	}

	static boolean isNotValid(int[] arr1, int[] arr2) {
		return arr1[0] > arr2[0] && arr1[1] > arr2[1];
	}
}
