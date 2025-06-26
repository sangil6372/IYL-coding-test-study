import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 2];  // i+2까지 안전하게 접근

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long total = 0;

        if (B <= C) {
            // 묶는 게 손해 → 단독 구매만
            for (int i = 0; i < N; i++) {
                total += (long) arr[i] * B;
            }
        } else {
            for (int i = 0; i < N; i++) {

                // 예외 처리: i+1 > i+2 → 2개 묶음 먼저
                if (arr[i + 1] > arr[i + 2]) {
                    int twoBundle = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
                    arr[i] -= twoBundle;
                    arr[i + 1] -= twoBundle;
                    total += (long) twoBundle * (B + C);
                }

                // 3개 묶음
                int threeBundle = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                arr[i] -= threeBundle;
                arr[i + 1] -= threeBundle;
                arr[i + 2] -= threeBundle;
                total += (long) threeBundle * (B + 2 * C);

                // 2개 묶음
                int twoBundle = Math.min(arr[i], arr[i + 1]);
                arr[i] -= twoBundle;
                arr[i + 1] -= twoBundle;
                total += (long) twoBundle * (B + C);

                // 남은 건 단독
                total += (long) arr[i] * B;
                arr[i] = 0;
            }
        }

        System.out.println(total);
    }
}
