import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Map<String, int[]> directions = new HashMap<String, int[]>();
		directions.put("R", new int[] {1,0});
		directions.put("L", new int[] {-1,0});
		directions.put("B", new int[] {0,-1});
		directions.put("T", new int[] {0,1});
		directions.put("RT", new int[] {1,1});
		directions.put("LT", new int[] {-1,1});
		directions.put("RB", new int[] {1,-1});
		directions.put("LB", new int[] {-1,-1});
		
		char[] temp = st.nextToken().toCharArray();
		int[] king = new int[] {temp[0]-'A'+1, temp[1]-'0'};
		temp = st.nextToken().toCharArray();
		int[] stone = new int[] {temp[0]-'A'+1, temp[1]-'0'};
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String dir = br.readLine();
			
			int curKingX = king[0];
			int curKingY = king[1];
			
			int[] move = directions.get(dir);
			
			int nextKingX = curKingX + move[0];
			int nextKingY = curKingY + move[1];
			// 다음 킹 위치 체스판 벗어나면 ?
			if (nextKingX<1||nextKingX>8||nextKingY<1||nextKingY>8) continue;
			if (stone[0]==nextKingX&&stone[1]==nextKingY) {
				int nextStoneX = stone[0]+move[0];
				int nextStoneY = stone[1]+move[1];
				
				if (nextStoneX<1||nextStoneX>8||nextStoneY<1||nextStoneY>8) continue;
				stone[0] = nextStoneX;
				stone[1] = nextStoneY;
			}
			king[0] = nextKingX;
			king[1] = nextKingY;
		}
		System.out.println((char)(king[0]-1+'A')+""+(char)(king[1]+'0'));
		System.out.println((char)(stone[0]-1+'A')+""+(char)(stone[1]+'0'));
	}

}
