import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
    
        int start = 1;
        int coverage = 2*w + 1; // 전파 적용범위
        for (int s : stations){
            int left = s - w;
            int right = s + w;
            if (start < left){
            // 연달아 있는 경우 제끼기 위함 
                int gap = left - start;
                answer += (gap+coverage-1)/coverage; // 올림
            }
            start = right + 1;
        }
        // 마지막 우측 처리 
        if ( start <= n){
            int gap = n - start+1 ;
            answer += (gap+coverage-1)/coverage; // 올림
        }

        return answer;
    }
}