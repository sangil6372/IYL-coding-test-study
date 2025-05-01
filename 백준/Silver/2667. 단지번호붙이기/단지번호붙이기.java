import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] distX = { 0, 1, 0, -1 };
	static int[] distY = { 1, 0, -1, 0 };
	static int[][] map;
	static boolean[][] visited;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

//		총 단지수
		int total = 0;
//		각 단지내 집의 수를 오름차순으로 정렬
		List<Integer> houseCnt = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					houseCnt.add(bfs(i, j));
					total++;
				}
			}
		}
		Collections.sort(houseCnt);
		System.out.println(total);
		for (int c : houseCnt) {
			System.out.println(c);
		}

	}

	static int bfs(int i, int j) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;
		int count = 1;

		while (!queue.isEmpty()) {
			int[] peek = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nextX = peek[0] + distX[k];
				int nextY = peek[1] + distY[k];
				if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
					if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
						visited[nextX][nextY] = true;
						count++;
						queue.add(new int[] { nextX, nextY });
					}
				}
			}
		}
		

		return count;
	}

}
