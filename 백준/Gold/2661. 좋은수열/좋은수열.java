import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String result = ""; 
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        dfs("");
        System.out.println(result);
    }
    static void dfs(String num) {
    	if (flag) return;
        if (num.length() == N) {
            if (isValid(num)) {
            	result = num;
            	flag = true;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
        	String next = num + i;
        	if (isValid(next))dfs(next);
        }
    }

    static boolean isValid(String num) {
       // 부분 수열이 있는지 확인해야 함 
    	int len = num.length();
    	for (int i = 1 ; i <= len/2 ; i++) {
    		// 같은 연속 부분 문자열이 있나.. ?
    		for (int j = 0 ; j <= len-2*i; j++) {
    			String a = num.substring(j, j+i);
    			String b = num.substring(j+i, j+2*i);
    			if (b.equals(a)) return false;
    		}
       	}
    	return true;
    }
}
