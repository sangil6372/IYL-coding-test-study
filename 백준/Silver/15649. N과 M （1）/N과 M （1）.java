import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

class Main {
	static StringBuilder sb;
	static boolean[] visited;
	static int N, M;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];

		backtracking(new ArrayList<Integer>(), 1);
		System.out.println(sb);
	}

	public static void backtracking(List<Integer> list, int length) {
		if (length == M + 1) {
			for (int n : list) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list.add(i);
				backtracking(list, length + 1);
				list.remove(list.size() - 1);
				visited[i] = false;
			}

		}

	}

}