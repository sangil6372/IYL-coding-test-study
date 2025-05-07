import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int [N];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0 ; i < N ; i++){
            while(!stack.isEmpty()&& numbers[stack.peek()] < numbers[i]){
                int idx = stack.poll();
                answer[idx] = numbers[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int idx = stack.poll();
            answer[idx] = -1;
        }
        
        return answer;
    }
}