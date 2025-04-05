import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {        
        Deque<int[]> deque = new ArrayDeque<>();
        
        for (int i = 0; i<priorities.length;i++){
            if (i == location){
                deque.addLast(new int[] {priorities[i], 1});
            }else{
                deque.addLast(new int[] {priorities[i], 0});
            }
        }
        
        int cnt = 1;
        while (!deque.isEmpty()){
            int[] cur = deque.poll();
            
            boolean isPriority = true;  // 가장 우선순위를 갖는지?
            for (int[] p : deque){
                if (cur[0] < p[0]){
                    deque.addLast(cur);
                    isPriority = false;                    
                    break;
                }
            }
            if(isPriority){
                if (cur[1] == 1) return cnt;
                cnt++;
            }
        }
        
            
        return cnt;
    }
}