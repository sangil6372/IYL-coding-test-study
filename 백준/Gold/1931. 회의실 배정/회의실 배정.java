
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

	
		int N = Integer.parseInt(st.nextToken());
		
		int[][] list = new int[N ][2];

		
		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			list[j][0] = Integer.parseInt(st.nextToken());
			list[j][1] = Integer.parseInt(st.nextToken());


		}

		Arrays.sort(list, new Comparator<int []>() {
				
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0]-o2[0];
				}
				else return o1[1]-o2[1];
			}
				
			
		});
		
		int cnt = 0; // 총 회의 개수
		int prevTime = 0;
		
		for (int i = 0; i < N; i++) {
			
			if (prevTime<= list[i][0]) {
				prevTime = list[i][1];
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
	}
}
