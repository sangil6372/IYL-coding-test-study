import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> stack = new ArrayDeque<>();

		int K = Integer.parseInt(br.readLine());

		while (K-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}
		int sum = 0;
		for (int s : stack) {
			sum += s;
		}
		System.out.println(sum);

	}

}
