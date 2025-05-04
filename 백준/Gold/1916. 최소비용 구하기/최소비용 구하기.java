import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 정점 개수
		int M = Integer.parseInt(br.readLine()); // 간선 개수

		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
//		간선 정보 
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(s).add(new int[] { e, w });
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		System.out.println(dijkstra(start, end, graph, N));
	}

	public static int dijkstra(int start, int end, List<List<int[]>> graph, int N) {
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		Arrays.fill(dist, INF);
		dist[start] = 0; // 시작점은 거리 0

//		overflow 방지로 Integer.compare로 비교 
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
		pq.offer(new int[] { 0, start });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
//			int currW = curr[0];   PQ에 넣는 거리 정보는 단순히 정렬 용! 
			int currV = curr[1];

			// Queue 에서 꺼냈을 때 처리 되었으면 건너 뜀!
			if (visited[currV])
				continue;
			visited[currV] = true;

			for (int[] next : graph.get(currV)) {
				int nextW = next[1];
				int nextV = next[0];
				if (dist[nextV] > dist[currV] + nextW) {
					dist[nextV] = dist[currV] + nextW;
					pq.offer(new int[] { dist[nextV], nextV });
				}
			}
		}

		return dist[end];
	}

}
