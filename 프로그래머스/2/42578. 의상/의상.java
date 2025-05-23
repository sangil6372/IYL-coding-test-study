import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        //각 종류별로 최대 1가지 의상만 착용
        // 헤드기어 2종류 안경 1종류 ?  3*2-1 5 
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] c : clothes){
            String key = c[1];
            map.put(key, map.getOrDefault(key,0)+1);
        }
        int sum = 1;
        for (String key : map.keySet()){
            answer *= (map.get(key)+1);
        }
        answer--; // 아무 것도 안 입은 경우
        return answer;
    }
}