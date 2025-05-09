import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			int x = 0;
			int y = 0;
			
			int[] dx = {0,1,0,-1};
			int[] dy = {1,0,-1,0};
			
			int idx = 0;
			int num = 2;
			arr[0][0] = 1;
			boolean turn = false;
			while(true) {
				// 다음 위치 확인
				int nx = x + dx[idx];
				int ny = y + dy[idx];
				
				// 방향 전환 조건 
				if (nx<0||ny<0||nx>=N||ny>=N||arr[nx][ny]!=0) {
					if (turn) break;
					idx = (idx+1)%4;
					turn = true;
					continue;
				}
				turn = false;
				arr[nx][ny] = num++;
				x = nx;
				y = ny;
			}
			sb.append("#" + test_case + "\n");
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < N ; j++) {
					sb.append(arr[i][j]+" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}