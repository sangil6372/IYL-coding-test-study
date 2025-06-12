
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static int[][] gear;
	static int[] d;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		gear = new int[5][8];

		// gear 입력
		for (int i = 1; i < 5; i++) {
			String[] str = sc.next().split("");
			for (int j = 0; j < 8; j++) {
				gear[i][j] = Integer.parseInt(str[j]);
			}

		}
		// N = 0, S == 1

	

		// 회전 수 K 입력
		int K = sc.nextInt();

		while (K-- > 0) {
			// 회전할 톱니바퀴 , 회전 방향 1 시계방향, -1 반시계 방향
			int gearNum = sc.nextInt();
			int dir = sc.nextInt();

			d= new int[5];
			d[gearNum] = dir;
			checkDir(gearNum);
			gearTurn();

		}
		int sum = 0;
		for (int i = 1; i < 5; i++) {
			if (gear[i][0] == 1) { // S 극인지 확인
				sum += Math.pow(2, i - 1);
			}
		}
		System.out.println(sum);
	}

	static void checkDir(int gearNum) {
		// 좌측 톱니 바퀴 검사
		for (int i=gearNum-1;i>0;i--) {
			if (gear[i][2]!=gear[i+1][6]) {
				d[i] = -d[i+1];
			}
			else break;
		}
		
		
		// 우측 톱니 바퀴 검사
		for (int i = gearNum+1;i<5;i++) {
			if (gear[i][6]!=gear[i-1][2]) {
				d[i] = -d[i-1];
			}else break;
			
		}
	}
	
	static void gearTurn() {
		int temp = 0;
		
		for(int i=1; i<=4; i++) { //모든 톱니에 대해서
			//시계방향 회전
			if(d[i] == 1) {
				temp = gear[i][7];
				for(int j=7; j>0; j--) {
					gear[i][j] = gear[i][j-1];
				}
				gear[i][0] = temp;
			}
			//반시계방향회전
			if(d[i] == -1) {
				temp = gear[i][0];
				for(int j=0; j<7; j++) {
					gear[i][j] = gear[i][j+1];
				}
				gear[i][7] = temp;
			}
		}
	}

}
