
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bReader.readLine());
		
		StringTokenizer st = new StringTokenizer(bReader.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int result = 0;

		for (int i = 0; i < N; i++) {
			result += arr[i]*(N-i);
		}
		
		System.out.println(result);
	}
}
