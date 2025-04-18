import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> deque = new ArrayDeque<>();
        
        for (char c : s.toCharArray()){
            if (c==')'){
                if (deque.isEmpty()||deque.peek()!='(') return false;
                else deque.pop();
            }
            else deque.push(c);
        }
        if (!deque.isEmpty()) return false;

        return answer;
    }
}