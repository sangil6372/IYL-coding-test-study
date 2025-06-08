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

		queue.offer(new int[] { x, y, 0 });
		visited[x][y] = true; // 시작점 방문 체크

		int maxDist = 0;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cx = curr[0], cy = curr[1], cd = curr[2];

			maxDist = Math.max(maxDist, cd);

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				int nd = cd + 1;

				if (nx >= 0 && ny >= 0 && nx < L && ny < W) {
					if (!visited[nx][ny] && graph[nx][ny] == 1) {
						visited[nx][ny] = true;
						queue.offer(new int[] { nx, ny, nd });
					}
				}
			}
		}
		return maxDist;
	}

}
