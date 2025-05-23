import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();

		while (N-- > 0) {
			String title = br.readLine();
			map.put(title, map.getOrDefault(title, 0) + 1);
		}
		String maxKey = "";
		int maxCnt = 0;
		for (String key : map.keySet()) {
			int value = map.get(key);
			if (maxCnt < value) {
				maxKey = key;
				maxCnt = value;
			}
			if (maxCnt == value && key.compareTo(maxKey) < 0 ) {
				maxKey = key;
				maxCnt = value;
			}
		}
		System.out.println(maxKey);
	}

}