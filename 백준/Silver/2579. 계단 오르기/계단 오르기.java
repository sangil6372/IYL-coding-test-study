import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
//		dp[i] = i번째 계단까지 도달했을 때 얻을 수 있는 최대 점수
		
		int[] stairs = new int[N+1];
		
		for (int i = 1 ; i <= N ; i++) {
			stairs[i] =  Integer.parseInt(br.readLine());
		}
		
		if (N==1) {
			System.out.println(stairs[1]);
			return;
		}
		dp[1] = stairs[1];
		dp[2] = stairs[1] + stairs[2];
		for(int i = 3; i <=N ;i++) {
//			조건을 만족하는 경우의 수 확인 
			dp[i] = Math.max(dp[i-2], dp[i-3]+stairs[i-1])+stairs[i];
		}
		System.out.println(dp[N]);
	}

}
