import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int rep = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");
		int minNum = Integer.MAX_VALUE;
		int maxNum = Integer.MIN_VALUE;

		for (int i = 0; i < rep; i++) {
			minNum = Math.min(Integer.parseInt(input[i]), minNum);
			maxNum = Math.max(Integer.parseInt(input[i]), maxNum);

		}

		System.out.println(minNum + " " + maxNum);
	}
}
