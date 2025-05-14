import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			char[] c = br.readLine().toCharArray();

			int count = 0;
			for (int i = 1; i < 15; i++) {
				boolean isValid = true;
				for (int j = 0; j < i; j++) {
					if (c[j] != c[i + j]) {
						isValid = false;
					}
				}
				if (isValid) {
					count = i;
					break;
				}
			}
			sb.append("#" + test_case + " " + count + "\n");

		}
		System.out.println(sb);
	}
}