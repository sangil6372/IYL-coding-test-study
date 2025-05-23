import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 하 좌 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rR = 0, cR = 0, rB = 0, cB = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    rR = i;
                    cR = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    rB = i;
                    cB = j;
                    map[i][j] = '.';
                }
            }
        }

        System.out.println(BFS(rR, cR, rB, cB));
    }

    static int BFS(int rR, int cR, int rB, int cB) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(rR, cR, rB, cB));
        visited[rR][cR][rB][cB] = true;

        int time = 0;
        while (!q.isEmpty()) {
            if (time == 10) return 0;
            for (int s = 0, size = q.size(); s < size; s++) {
                Point curr = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nrR = curr.rR, ncR = curr.cR;
                    int nrB = curr.rB, ncB = curr.cB;
                    boolean flagREnd = false, flagBEnd = false;
                    int distR = 0, distB = 0;

                    while (true) {
                        int newR = nrR + dir[i][0];
                        int newC = ncR + dir[i][1];
                        if (map[newR][newC] == '#') break;
                        if (map[newR][newC] == 'O') {
                            flagREnd = true;
                            break;
                        }
                        nrR = newR;
                        ncR = newC;
                        distR++;
                    }

                    while (true) {
                        int newB = nrB + dir[i][0];
                        int newC = ncB + dir[i][1];
                        if (map[newB][newC] == '#') break;
                        if (map[newB][newC] == 'O') {
                            flagBEnd = true;
                            break;
                        }
                        nrB = newB;
                        ncB = newC;
                        distB++;
                    }

                    if (flagBEnd) continue;
                    if (flagREnd) return 1;

                    if (nrR == nrB && ncR == ncB) {
                        if (distR > distB) {
                            nrR -= dir[i][0];
                            ncR -= dir[i][1];
                        } else {
                            nrB -= dir[i][0];
                            ncB -= dir[i][1];
                        }
                    }

                    if (!visited[nrR][ncR][nrB][ncB]) {
                        visited[nrR][ncR][nrB][ncB] = true;
                        q.offer(new Point(nrR, ncR, nrB, ncB));
                    }
                }
            }
            time++;
        }
        return 0;
    }

    static class Point {
        int rR, cR, rB, cB;
        public Point(int rR, int cR, int rB, int cB) {
            this.rR = rR; this.cR = cR; this.rB = rB; this.cB = cB;
        }
    }
}
