import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> lastSeen = new HashMap<>();
        
        for (int i  = 0 ; i< s.length(); i++){
            char c = s.charAt(i);
            answer[i] = lastSeen.containsKey(c) ? i - lastSeen.get(c) : -1;
            lastSeen.put(c, i);
        }

        return answer;
    }
}