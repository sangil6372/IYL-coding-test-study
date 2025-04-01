import java.util.*;


class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for(int p : people){
            list.add(p);
        }
        
        Collections.sort(list);
        
        int start =  0;
        int end = list.size()-1;
        
        while (start <= end){
            if (list.get(start)+list.get(end) <= limit){
                start++;
            }
            end--;
            answer++;
        }
        
        return answer;
    }
}