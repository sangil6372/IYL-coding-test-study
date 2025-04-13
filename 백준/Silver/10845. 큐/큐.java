import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> queue = new ArrayDeque<>();

		int n = Integer.parseInt(br.readLine());
				
		while (n-- > 0) {
			String[] input = br.readLine().split(" ");
			
			String order = input[0];
					
			if (order.equals("push")) {
				queue.add(Integer.parseInt(input[1]));

			} else if (order.equals("pop")) {
				if (queue.isEmpty()) {
					System.out.println("-1");
				} else
					System.out.println(queue.poll());
			} else if (order.equals("size")) {
				System.out.println(queue.size());
			} else if (order.equals("empty")) {
				if (queue.isEmpty()) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			} else if (order.equals("front")) {
				if (queue.isEmpty()) {
					System.out.println("-1");
				} else
					System.out.println(queue.peek());
			} else if (order.equals("back")) {
				if (queue.isEmpty()) {
					System.out.println("-1");
				} else
					System.out.println(queue.peekLast());
			}

		}

	}

}
