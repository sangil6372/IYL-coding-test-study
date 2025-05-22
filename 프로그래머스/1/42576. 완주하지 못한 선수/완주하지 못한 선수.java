import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        
        for (String p : participant){
            map1.put(p, map1.getOrDefault(p,0)+1);   
        }
        
        for (String c : completion){
            map2.put(c, map2.getOrDefault(c,0)+1);
        }
        
        for (String str : map1.keySet()){
            int num1 = map1.get(str);
            int num2 = map2.getOrDefault(str,0);
            if (num1!=num2){
                answer = str;
                break;
            }
            
        }
        
        
        
        
        return answer;
    }
}