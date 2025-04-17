import java.util.*;

class Solution{
    public int solution(String s){        
        Deque<Character> deque = new ArrayDeque<>();
        
        for (char c : s.toCharArray()){
            if (!deque.isEmpty()&&deque.peek()==c) deque.poll();            
            else deque.push(c);
        }
        return deque.isEmpty()? 1 : 0;
    }
}