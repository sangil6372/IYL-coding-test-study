import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
    /*    
       야근 피로도 어떻게 줄이지 ?
       고루 작게 만들면 되나 ? 
       그러면 단순 그리디..?
     */   
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> n2-n1);
        for (int w : works){
            pq.add(w);
        }
        
        while (n --> 0){
            int num = pq.poll();
            if (num == 0) return 0;
            pq.add(num-1);
        }
        for (int num : pq){
            answer += num*num;
            
        }
        
        
        return answer;
    }
}