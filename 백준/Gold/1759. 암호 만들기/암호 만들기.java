import java.io.*;
import java.util.*;

public class Main {

	static final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	static char[] letters, password;
	static int L, C;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		letters = new char[C];
		password = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			letters[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(letters); // 알파벳 순서로 정렬
		dfs(0, 0);
		System.out.println(sb);
	}

	static void dfs(int depth, int index) {
		if (depth == L) {
			if (isValid(password))
				sb.append(password).append("\n");
			return;
		}
		for (int i = index; i < C; i++) {
			password[depth] = letters[i];
			dfs(depth + 1, i + 1);
		}
	}

	static boolean isValid(char[] arr) {
		int v = 0, c = 0;
		for (char ch : arr) {
			if (vowels.contains(ch))
				v++;
			else
				c++;
		}
		return v >= 1 && c >= 2; // 모음 1개 이상, 자음 2개 이상인지 체크
	}
}
