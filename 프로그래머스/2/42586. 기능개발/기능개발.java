import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0 ; i < progresses.length; i++) {
            int remain = 100-progresses[i];
            deque.addLast((remain+speeds[i]-1)/speeds[i]);
        }
        
        while(!deque.isEmpty()){
            int cur = deque.poll();
            int cnt = 1;
            while(!deque.isEmpty()&&deque.peek()<=cur){
                deque.poll();
                cnt++;
            }
            
            answer.add(cnt);
        }
        
        
        return answer;
    }
}