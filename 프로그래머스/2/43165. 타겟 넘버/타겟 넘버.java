import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = bfs(numbers, target);
        return answer;
    }

    public static int bfs(int[] numbers, int target){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 0;
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0 ; i < size ; i++){
                int curState = queue.poll();   
                if (depth == numbers.length){
                    if (curState == target) {
                        count++;
                        continue;
                    }
                }
                else {
                    queue.add(curState+numbers[depth]);
                    queue.add(curState-numbers[depth]);
                }
            }
            depth++;
        }
        return count;
    }
    
}