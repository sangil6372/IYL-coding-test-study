import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long INF = Long.MAX_VALUE;
    static ArrayList<int[]>[] G;
    static long[][] V;
    static PriorityQueue<Node> heap;

    static class Node implements Comparable<Node> {
        long x;
        int t, state;
        Node(long x, int t, int state) {
            this.x = x;
            this.t = t;
            this.state = state;
        }
        public int compareTo(Node o) {
            return Long.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        G = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) G[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int flavor = Integer.parseInt(st.nextToken());
            G[a].add(new int[]{b, t, flavor});
            G[b].add(new int[]{a, t, flavor});
        }

        V = new long[N+1][2];
        for (int i = 1; i <= N; i++) Arrays.fill(V[i], INF);
        V[1][0] = 0;
        heap = new PriorityQueue<>();
        heap.offer(new Node(0, 1, 0));

        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            long x = cur.x;
            int u = cur.t, state = cur.state;

            if (x > V[u][state]) continue;

            for (int[] e : G[u]) {
                int v = e[0], nt = e[1], flavor = e[2];

                if (V[v][state] > x + nt) {
                    V[v][state] = x + nt;
                    heap.offer(new Node(V[v][state], v, state));
                }

                if (state == 0 && V[v][1] > x + nt - flavor) {
                    V[v][1] = x + nt - flavor;
                    heap.offer(new Node(V[v][1], v, 1));
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(Math.min(V[i][0], V[i][1]));
        }
    }
}
