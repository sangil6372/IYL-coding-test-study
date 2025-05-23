import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static List<List<Integer>> graph;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		graph = new ArrayList<List<Integer>>();
		parents = new int[N+1];
		
		for (int i = 0 ; i <= N ;i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0 ; i < N-1 ;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(e);
			graph.get(e).add(s);
		}
		bfs();
		for (int i = 2 ; i <= N ;i++) {
			System.out.println(parents[i]);
		}
		
	}
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);  // root 가  1임 
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for (int next : graph.get(curr)) {
				if (!visited[next]) {
					parents[next] = curr;
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		
		
		
	}
	

}