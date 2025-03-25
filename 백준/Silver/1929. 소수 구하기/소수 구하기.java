import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        // 에라토스의 체로 풀기엔 ? N이 어디가 시작인지 애매함 
        for (int i = N ; i<= M ; i++) {
            if (isPrime(i)) sb.append(i + "\n");    
        }
        System.out.println(sb);
    }
    static boolean isPrime(int n){
        if (n <=1 ) return false;
        for (int i = 2; i<=Math.sqrt(n); i++){
            if (n%i==0) return false;
        }
        return true;
    }
}