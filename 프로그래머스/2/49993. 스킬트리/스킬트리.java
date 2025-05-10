import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] skillLoc = new int [skill.length()];
        for (String skill_tree : skill_trees){
            int  prevIdx = -1;
            boolean isOrdered = true;
            for (char c : skill.toCharArray()){
                int currIdx = skill_tree.indexOf(c); // 없으면 -1 리턴 
                if (currIdx == -1) currIdx = Integer.MAX_VALUE;
                if (currIdx < prevIdx) {
                    isOrdered = false; // 순서 잘못되는게 하나라도 있으면 체크 
                    break;
                }
                prevIdx = currIdx;
            }
            if (isOrdered) answer++;
        }
        
        
        
        
        return answer;
    }
}