import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        
        for (String operation : operations){
            String[] op = operation.split(" ");
            String command = op[0];
            int num = Integer.parseInt(op[1]);

            if (command.equals("I")) {
                minHeap.offer(num);
                maxHeap.offer(num);
            } else if (command.equals("D")) {
                if (num == 1 && !maxHeap.isEmpty()) {
                    int maxVal = maxHeap.poll();
                    minHeap.remove(maxVal); // 동기화
                } else if (num == -1 && !minHeap.isEmpty()) {
                    int minVal = minHeap.poll();
                    maxHeap.remove(minVal);
                }
            }
        }
        if (minHeap.isEmpty()) return new int[] {0,0};
        else return new int[] {maxHeap.poll(),minHeap.poll()};
        
    }
}