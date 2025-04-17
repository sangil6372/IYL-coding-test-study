import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        while (T-- > 0) {
            Deque<Character> stack = new ArrayDeque<>();
            String input = br.readLine();
            boolean flag = true;
            for (char c : input.toCharArray()) {
                if (c == '(') stack.push(c);
                else if (stack.isEmpty()||stack.peek()==')') {
                    flag = false;
                    break;
                }
                else stack.pop();
            }
            if (flag && stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
