import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> dQ = new ArrayDeque<>();
        dQ.add(arr[0]);
        
        for (int i = 1; i<arr.length;i++){
            if (dQ.getLast()==arr[i]) continue;
            dQ.addLast(arr[i]);
        }
        int length = dQ.size();
        int[] answer = new int[length];
        
        for (int i = 0; i<length;i++){
            answer[i] = dQ.poll();
        }
        
        return answer;
    }
}