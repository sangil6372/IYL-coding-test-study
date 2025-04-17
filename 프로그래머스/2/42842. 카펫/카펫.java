import java.util.*;

class Solution {
    public List<Integer> solution(int brown, int yellow) {
        List<Integer> answer = new ArrayList<>();
        int total = brown + yellow;
            
        for (int h = 3; h <= total/h; h++){
            int w = total/h;
            if ((h-2)*(w-2)==yellow){
                answer.add(w);
                answer.add(h);
                return answer;
            }
        }
        return answer;
    }
}