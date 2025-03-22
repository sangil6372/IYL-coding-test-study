import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] input = br.readLine().split(" ");

			if (input[0].equals("0") && input[1].equals("0"))
				break;

			int num1 = Integer.parseInt(input[0]);
			int num2 = Integer.parseInt(input[1]);

			System.out.println(num1 + num2);
		}

	}
}
