import java.util.*;
import java.io.*;

public class Main{
	
	static int N, M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		// M개를 고른 수열
		// 비내림차순
		// A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(arr);
		backTracking(0, 0);
		System.out.print(sb);
		// 입력 끝
	}
	static void backTracking(int  index, int length) {		
		// 항상 종료 조건이 어려웠음
		if (length == M) {
			for (int i = 0 ; i < M; i++) sb.append(result[i] + " ");
			sb.append("\n");
			return;
		}		
		
		int prev = -1;
		for (int i = index; i < N ; i++) {
			// 선택하거나 안하거나 둘로 나뉘어야 할 거 같은데..
			// 여기서 i는 시작점임 
			if (arr[i] == prev) continue;
			prev = arr[i];
			result[length] = arr[i];
			backTracking(i+1, length+1);
		}
	}
	
}