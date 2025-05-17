import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        
        int answer = 0;
//      일단 상하 좌우 체크 
        Map<Character, int[]> map = new HashMap<>();
        map.put('U',  new int[] {0,1});
        map.put('D',  new int[] {0,-1});
        map.put('R',  new int[] {1,0});
        map.put('L',  new int[] {-1,0});
//         (0,0) -> (1,0) 이 됐다가 다시 (1,0) -> (0,0) 이걸
        int curX = 0;
        int curY = 0;
        for (char c : dirs.toCharArray()){
            int[] dir = map.get(c);
            int nextX = curX + dir[0];
            int nextY = curY + dir[1];
            if (nextX <- 5  || nextY < -5 || nextX > 5 || nextY > 5) continue;
            
//          set 에다가 저장 해야함 
            set.add(curX +"," + curY +":" + nextX + "," + nextY);
            set.add(nextX +"," + nextY +":" + curX + "," + curY);
            curX = nextX;
            curY = nextY;
        }
        answer = set.size()/2;
        
        return answer;
    }
}