import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i<= N; i++){
            deque.add(i);
        }
        sb.append("<");

        int index = 0;
        while(deque.size()>1) {
            index++;
            int curNode = deque.poll();
            if (index%K==0) {
                sb.append(curNode + ", ");
            }
            else{
                deque.addLast(curNode);
            }
        }
        sb.append(deque.poll());
        sb.append(">");
        System.out.println(sb);
    }
}
