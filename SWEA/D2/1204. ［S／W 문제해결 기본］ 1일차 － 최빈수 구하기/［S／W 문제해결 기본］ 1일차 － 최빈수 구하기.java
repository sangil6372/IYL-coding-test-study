import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int t_num = Integer.parseInt(br.readLine());
			
			Map<Integer, Integer> map = new HashMap<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				map.put(num, map.getOrDefault(num, 0)+1);
			}
			int maxKey = 0;
			int maxValue = Integer.MIN_VALUE;
			for (int key : map.keySet()) {
				int currV = map.get(key);
				if (maxValue < currV) {
					maxKey = key;
					maxValue = currV;
				}else if (maxValue == currV) {
					maxKey = Math.max(maxKey, key);
				}
			}
			sb.append("#" + t_num + " " + maxKey + "\n");
		}
		System.out.println(sb);
	}
}