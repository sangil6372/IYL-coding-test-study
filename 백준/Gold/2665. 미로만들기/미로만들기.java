import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] graph;
	static int[][] dist;
	static int INF = Integer.MAX_VALUE;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 검은 방 1 흰방 0 가중치를 부여
		// 최대로 많은 흰방을 거치면..? 결과가 같아지는 거 아닌가?

		n = Integer.parseInt(br.readLine());

		graph = new int[n][n];
		dist = new int[n][n];

		for (int i = 0; i < n; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {

				graph[i][j] = c[j] - '0' == 0 ? 1 : 0;

			}
			Arrays.fill(dist[i], INF); // 점수 최대화
		}
		
		dijkstra();
		System.out.println(dist[n - 1][n - 1]);

	}

	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[2] - n2[2]);
		pq.offer(new int[] { 0, 0, 0 }); // (0,0) 으로 점수 0
		dist[0][0] = 0;

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int cX = curr[0];
			int cY = curr[1];
			int cDist = curr[2];
			if (cX == n - 1 && cY == n - 1) {
				return; // 이미 [n-1][n-1]은 최신 상태로 갱신했다는 뜻
			}

			if (cDist != dist[cX][cY])
				continue;

			// 갱신 가능하면 갱신
			for (int i = 0; i < 4; i++) {
				int nX = cX + dx[i];
				int nY = cY + dy[i];

				if (nX >= 0 && nY >= 0 && nX < n && nY < n) {
					// 갱신 시도
					int newDist = cDist + graph[nX][nY];
					if (dist[nX][nY] > newDist) {
						dist[nX][nY] = newDist;
						pq.offer(new int[] { nX, nY, newDist });
					}
				}

			}

		}

	}
}