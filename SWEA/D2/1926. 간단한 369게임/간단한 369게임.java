import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		for (int i = 1 ; i <= N ;i++) {
			String curr = Integer.toString(i);
			
			boolean isContains = false;
			for (char c : curr.toCharArray()) {
				if (c == '3' || c == '6' || c == '9') {
					sb.append("-");
					isContains = true;
				}
			}
			if (!isContains) sb.append(curr);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}