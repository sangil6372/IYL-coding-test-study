import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		char[] nums = input[0].toCharArray();
		int base = Integer.parseInt(input[1]);
		int result = 0;
		int maxDigit = nums.length;

		for (int i = 0; i < maxDigit; i++) {
			char c = nums[i];
			int num = 0;
			if (c >= '0' && c <= '9') {
				num = c - '0';
			} else if (c >= 'A' && c <= 'Z') {
				num = 10 + c - 'A';
			}
			result += Math.pow(base, maxDigit - i - 1) * num;
		}
		System.out.println(result);
	}
}
