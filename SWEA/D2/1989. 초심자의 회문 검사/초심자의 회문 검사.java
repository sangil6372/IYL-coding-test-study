import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			char[] c = br.readLine().toCharArray();

			int s = 0;
			int e = c.length - 1;

			boolean isP = true;
			while (s <= e) {
				if (c[s] != c[e]) {
					isP = false;
					break;
				}
				s++;
				e--;
			}
			sb.append("#" + test_case + " ");
			if (isP)
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		System.out.println(sb);
	}
}