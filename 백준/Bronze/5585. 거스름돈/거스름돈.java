
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] coins = {500,100,50,10,5,1};
		
		n = 1000-n;
		
		int cnt=0;
		
		for (int i=0;i<6&&n>0;i++) {
			cnt+=n/coins[i];
			n%=coins[i];
		}
		System.out.println(cnt);
		
		sc.close();
	}

}
