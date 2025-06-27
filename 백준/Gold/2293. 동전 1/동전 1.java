import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]); // n가지 종류의 동전
        int k = Integer.parseInt(input[1]); // 적당히 사용해서, 그 가치의 합이 k원

        int[] dp = new int[k+1];
        int[] coins = new int [n];


        for (int i = 0; i < n ; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
//      코인 입력 끝
        dp[0] = 1; // 이건 잘 모르겠네

//      경우의 수를 구하는거라 
        for (int i = 0 ; i < n; i++){
            for (int j = coins[i] ;j <= k ; j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        
//      coin[0] 1 -> 1원 부터 
//       dp[1] 부터 채우기 
        
        
        System.out.println(dp[k]);
    }
}

