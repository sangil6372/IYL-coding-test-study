import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] tree;

    static void update(int idx, int val) {
        while (idx <= N) {
            tree[idx] += val;
            idx += idx & -idx;
        }
    }

    static int query(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= idx & -idx;
        }
        return sum;
    }

    static int find(int k) {
        int left = 1, right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid - query(mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[N + 2];
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int[] ans = new int[N + 1];

        // 작은 수부터 순서대로 넣는다
        for (int i = 1; i <= N; i++) {
            int pos = find(A[i] + 1);
            ans[pos] = i;
            update(pos, 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.print(sb);
    }
}
