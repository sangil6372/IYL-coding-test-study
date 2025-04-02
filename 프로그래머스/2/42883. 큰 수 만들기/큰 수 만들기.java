import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : number.toCharArray()){
            while ( k > 0 &&!stack.isEmpty() && stack.peek() < c ){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
//      이렇게 만들어진 숫자는 4321 처럼 내림차순 같은 형태        
        while (k>0){  
            stack.pop();
            k--;
        }
        for (char c : stack){
            sb.append(c);
        }
        
        return sb.reverse().toString();
    }
}