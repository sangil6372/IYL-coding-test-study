import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MOD = 1000000;
        final int PISANO = 1500000;

        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        int n = (int)(N % PISANO);
        int[] fib = new int[PISANO];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i-1] + fib[i-2]) % MOD;
        }

        System.out.println(fib[n]);
    }
}
