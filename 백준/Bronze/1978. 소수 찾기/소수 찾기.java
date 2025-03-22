import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int cntPrime = 0;
		for (int i = 0; i < N ;i++) {
			int num = Integer.parseInt(input[i]);
			if (isPrime(num)) cntPrime++; 
		}
		System.out.println(cntPrime);
	}

	static boolean isPrime(int num) {
		if (num < 2) return false;
		for (int i = 2; i < num; i++ ) {
			if (num%i==0) return false;
		}
		return true;
	}
}
