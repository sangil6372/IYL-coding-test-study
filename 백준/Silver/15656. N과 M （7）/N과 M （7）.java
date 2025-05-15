import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

class Main {
	static StringBuilder sb;
	static boolean[] visited;
	static int N, M;
	static int[] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		backtracking(new ArrayList<Integer>(), 0, 1);
		System.out.println(sb);
	}

	public static void backtracking(List<Integer> list, int cur, int length) {
		if (length == M + 1) {
			for (int n : list) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0 ; i < arr.length; i++) {
//			if (!visited[i]) {
//				visited[i] = true;
				list.add(arr[i]);
				backtracking(list, i, length + 1);
				list.remove(list.size() - 1);
//				visited[i] = false;
//			}

		}

	}

}