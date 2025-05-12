import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
    static int result;
    static int N,K;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String[] r_score = new String[] {
        		"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"
        };
        
        for (int test_case = 1 ; test_case <= T; test_case++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        	
            
            int[] student = new int [N+1];
            // N명의 학생
            for (int i = 1 ; i <= N ; i++) {
            	st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int score = a*35 + b*45 + c*20;
                
                student[i] = score;
            }
//           이제 student 배열에는 각자의 스코어 점수가 있음 
//           student[K]보다 큰 애들이 몇개 인지 체크 하면 백분위를 구할 수 있지 않나? 
            int k_score = student[K];
            int count = 0;
            for (int s : student) {
            	if (k_score < s) count++;
            }
            
//          이제 100명 중에 본인보다 잘하는 애들이 7명 있다고 치면 7/100 *10 -> 0번 째 인덱스
            String result = r_score[(count*100/N)/10];
            
            
        	sb.append("#" + test_case + " " + result +"\n");
        }
        System.out.println(sb);
    }    
}

