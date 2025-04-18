import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        
//      가격이 떨어지지 않은 기간? Stack ?
//       0 1 2 3 4 -> 
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0 ; i < length; i++){
            while (!stack.isEmpty()&&prices[i] < prices[stack.peek()]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        
//      남은 애들은 끝까지 안 떨어짐 
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = length - idx - 1;
        }        
        
        
        
        return answer;
    }
}