import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int maxNum = Integer.MIN_VALUE;
		int maxRow = 0;
		int maxCol = 0;
		for (int i = 0; i < 9; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				int curNum = Integer.parseInt(input[j]);
				if (curNum > maxNum) {
					maxNum = curNum;
					maxRow = i + 1;
					maxCol = j + 1;
				}
			}
		}
		System.out.println(maxNum + "\n" + maxRow + " " + maxCol);
	}
}
