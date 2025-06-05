import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		// 두 수를 고름(같은 수 일 수도 있음)-> 차이가 M 이상 + 제일 작은 경우   

		// ex) 1 5 3 -> 3이상 가장 작은 차이? 1 5 -> 차이 4
		// 1 3 5 라고 할 때 1 검사 -> 3 5 .... 이런식으로 하다가 처음으로 넘기는 시점 gap 체크 
		
		// 첫째 줄에 M 이상이면서 가장 작은 차이를 출력
		
		int minGap = Integer.MAX_VALUE;
		
		for (int i = 0 ; i < N ; i++) {
			
			int diff = 0;
			for (int j = i ; j < N ; j++) {
				diff = arr[j] - arr[i];
				if (diff >= M) {
					minGap = Math.min(minGap, diff);
					break;
				}
			}
		}
		
		
		
		
		
		
		System.out.println(minGap);
		
	}
}
