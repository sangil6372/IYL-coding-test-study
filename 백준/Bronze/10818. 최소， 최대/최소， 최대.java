import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int rep = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int minNum = Integer.MAX_VALUE;
		int maxNum = Integer.MIN_VALUE;

		for (int i = 0; i < rep; i++) {
			int num = Integer.parseInt(st.nextToken());
			minNum = Math.min(num, minNum);
			maxNum = Math.max(num, maxNum);
		}

		System.out.println(minNum + " " + maxNum);
	}
}
