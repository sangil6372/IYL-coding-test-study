import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i< progresses.length; i++){
            int remain = (100-progresses[i]+speeds[i]-1)/speeds[i];
            deque.addLast(remain);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!deque.isEmpty()){
            int curNode = deque.poll();
            
            int cnt = 1;
            while(!deque.isEmpty()&&curNode>=deque.peek()){
                deque.poll();
                cnt++;                
            }
            list.add(cnt);
        }
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++ ){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}