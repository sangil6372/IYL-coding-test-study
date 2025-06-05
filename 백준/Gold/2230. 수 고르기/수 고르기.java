import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int min;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);
        findNum();
        System.out.println(min);
    }

    public static void findNum() {
        int start = 0;
        int end = 0;
        while (start < N && end < N) {
            int temp = numbers[end] - numbers[start];
            if (temp >= M) {
                min = Math.min(min, temp);
                start++;
            } else {
                end++;
            }
        }
    }


}