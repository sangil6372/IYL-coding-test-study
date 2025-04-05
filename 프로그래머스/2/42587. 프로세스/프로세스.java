import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<priorities.length; i++){
            priorityQueueHighest.offer(priorities[i]);
        }
		while(!priorityQueueHighest.isEmpty()) {
			for(int i=0; i<priorities.length; i++) {
				if(priorities[i] == priorityQueueHighest.peek()) {
					priorityQueueHighest.poll();
					answer++;
					if(i == location)
						return answer;
				}
			}
		}  
        return answer;
    }
}