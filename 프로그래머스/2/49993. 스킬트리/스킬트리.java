class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
//  indexOf 로 문자열에서 문자의 인덱스를 알 수 있음 
        
        for (String skill_tree : skill_trees){
//             각 문자열 검증 ㄱㄱ
            /*
            첨에 든 생각은 
            CBD -> 123 135 혹은 1_4 이런식일텐데 
            그러면 바깥 반복문을 skill로 해야하나? 
            단조성만 확인하면 되니깐 <- 이전 위치 기록보다 한 번이라도 작아지면 컷
            */
            int prevIdx = -1;
            boolean isOrdered = true;
            for(char c : skill.toCharArray()) {
                int currIdx = skill_tree.indexOf(c);
                if (currIdx == -1) currIdx = Integer.MAX_VALUE;
                
                if (prevIdx > currIdx) {
                    isOrdered = false;
                    break;
                }
                
                prevIdx = currIdx;
            }
            if (isOrdered) answer++;
        }
        
        
        
        return answer;
    }
        
}