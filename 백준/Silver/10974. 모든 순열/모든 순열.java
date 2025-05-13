import java.util.Scanner;

public class Main {
    static int[] arr;
    static int N;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        dfs(0, "");
        System.out.println(sb.toString());
    }

    static void dfs(int depth, String current) {
        // 순열이 완성되었을 때 출력
        if (depth == N) {
            sb.append(current).append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, current + arr[i] + " ");
                visited[i] = false;
            }
        }
    }
}
