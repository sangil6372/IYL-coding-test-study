import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static char[] sign;
    static boolean[] visited = new boolean[10];
    static List<String> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        sign = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        dfs(0, "");

        // 정렬해서 최소/최대 출력
        Collections.sort(answers);
        System.out.println(answers.get(answers.size() - 1)); // 최대값
        System.out.println(answers.get(0)); // 최소값
    }

    static void dfs(int depth, String num) {
        if (depth == k + 1) {
            answers.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;
            
            
            
            if (depth == 0 || isValid(num.charAt(depth-1) - '0', i, sign[depth - 1])) {
                visited[i] = true;
                dfs(depth + 1, num + i);
                visited[i] = false;
            }
        }
    }

    static boolean isValid(int a, int b, char op) {
        if (op == '<') return a < b;
        else return a > b;
    }
}
