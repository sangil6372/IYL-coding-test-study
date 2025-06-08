import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] graph;
	static boolean[][] visited;
	static int L, W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		graph = new int[L][W];

		for (int i = 0; i < L; i++) {
			char[] chArr = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				if (chArr[j] == 'L')
					graph[i][j] = 1;
				else
					graph[i][j] = 0;
			}
		}

		int maxDistance = 0;

		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				if (graph[i][j] == 1) {
					maxDistance = Math.max(maxDistance, bfs(i, j));
				}
			}
		}
		System.out.println(maxDistance);
	}

	// 최단 거리 중 가장 긴...!
static int bfs(int x, int y) {
	Queue<int[]> queue = new LinkedList<>();
	visited = new boolean[L][W];
	visited[x][y] = true;
	queue.offer(new int[] { x, y });

	int depth = -1;

	while (!queue.isEmpty()) {
		int size = queue.size();
		depth++; // 한 레벨 깊어질 때마다 증가

		for (int i = 0; i < size; i++) {
			int[] curr = queue.poll();
			int cx = curr[0];
			int cy = curr[1];

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx >= 0 && ny >= 0 && nx < L && ny < W) {
					if (!visited[nx][ny] && graph[nx][ny] == 1) {
						visited[nx][ny] = true;
						queue.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}
	return depth;
}


}
