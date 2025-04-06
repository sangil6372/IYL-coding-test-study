 import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		int[] arr = new int[input.length+1];
		for (int i = 0; i< input.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		// 아래에서부터 핵심 로직 		
		int startIdx = 0;
		int endIdx = 0; // endIdx 는 다음에 더할 위치!!
		int sum = 0;
		int count = 0;
		while (endIdx < N+1) { // 종료하기 전에 기회를 줌
			if (sum < M) {
		        sum += arr[endIdx++]; // 현재 위치를 더하고 다음으로 end이동
			}
			else if (sum > M) {
						sum -= arr[startIdx++];  // 현재 위치를 빼고 다음으로 start 이동
			}
			else {  // (sum == M)
		        count++;
						sum -= arr[startIdx++]; // end를 증가 시키면 범위를 벗어남! 
		    } 
		}
		System.out.println(count);
	}
}