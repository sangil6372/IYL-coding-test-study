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
		int count = 0;
		
//		for (int i = 0 ; i < N; i++) {
//			int sum = 0;
//			for (int j = i; j < arr.length; j++) {
//				sum += arr[j];
//				if (sum == M) count++; 
//			}
//		}
		int startIdx = 0;
		int endIdx = 0;
		int sum = 0;
		while (endIdx < N || sum >= M) { // 종료하기 전에 기회를 줌
			if (sum < M) {
		        sum += arr[endIdx++];
			}
			else if (sum > M) {
				sum -= arr[startIdx++];
			}
			else {  // (sum == M)
		        count++;
				sum -= arr[startIdx++];
		    } 
		}
		
		System.out.println(count);
	}
}
