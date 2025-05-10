import java.util.*;


class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<int[]> queue = new ArrayDeque<>();

        int index = 0;
        int time = 0; 
        int curWeight = 0;
        
        // 트럭 다 통과 할 때까지 반복
        while(index < truck_weights.length ||!queue.isEmpty()){
            time ++;
            
            // 다리 위에 있는 트럭 이동
            if (!queue.isEmpty() && queue.peek()[1] == bridge_length){
                curWeight -= queue.poll()[0];
            }
            // 다음 트럭을 다리위에 올릴 수 있는지 확인 
            if (index < truck_weights.length && truck_weights[index] + curWeight <= weight){
                queue.add(new int[] {truck_weights[index], 0});
                curWeight += truck_weights[index];
                index++;
            }
            // 모든 트럭 한 칸씩 이동
            for (int[] q : queue){
                q[1]++;
            }
        }
        
        
        return time;
    }
}