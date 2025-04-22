import java.util.*;

class Solution {
    public Map<String, Integer> getSubString(String str){
        Map<String, Integer> map = new HashMap<>();
//         두 글자씩 끊어서 각 글자 별 개수를 기록 
        for (int i = 0; i<str.length()-1; i++){
            String next = str.substring(i,i+2);
            if (!next.matches("[a-z]{2}")) continue;
            map.put(next,map.getOrDefault(next,0)+1);
        }
        return map;
    }
    
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 자카드 유사도 = 교집합 크기/ 합집합 크기 
        // 모두 공집합일 경우 1
        // 두 글자 씩 끊음 , 중복 허용하는 다중집합
        // 공백, 숫자, 특수 문자 들어있으면 글자 쌍 버림 
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String,Integer> map1 = getSubString(str1);
        Map<String,Integer> map2 = getSubString(str2);
        
        int intersection = 0;
        int union = 0;
        
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());
        
        for (String s : allKeys){
            int count1 = map1.getOrDefault(s,0);
            int count2 = map2.getOrDefault(s,0);
            
            intersection += Math.min(count1,count2);
            union += Math.max(count1,count2);
        }
        
        if (union == 0 ) return 65536;
        
        double jaccard = (double) intersection/ (double) union;
        return (int)(jaccard*65536);
        
        
    }
}