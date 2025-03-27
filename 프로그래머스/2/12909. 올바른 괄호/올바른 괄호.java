import java.util.*;
import java.io.*;


class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> dq = new ArrayDeque<>();
        
        for (char c : s.toCharArray()){
            if (c == '('){
                dq.addLast(c);
            }else if ( c == ')' ){
                if(dq.isEmpty()) return false;
                dq.pop();
            }
        }
        if (!dq.isEmpty()) answer = false;
        
        return answer;
    }
}