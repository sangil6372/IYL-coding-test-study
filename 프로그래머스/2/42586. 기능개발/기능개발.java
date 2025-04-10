import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
       
        List<Integer> cntList = new ArrayList<>();
        int N = progresses.length;
        
        int[] days = new int[N];
        
        for (int i = 0; i < N ; i++){
            int remaining = 100 - progresses[i];
            days[i] = (remaining + speeds[i]-1)/speeds[i]; // 올림 해주기 위함!
        }
       
        int left = 0;
        while(left < N) {
            int right = left + 1; // 탐색 시작에서 right는 left 바로 다음 위치부터 시작
            while(right < N && days[right] <= days[left]) {
                right++;
            }
            cntList.add(right-left); // 여기서 구간의 길이가 배포 개수! 
       
            left = right; // 다음 구간 탐색 
        }
       
        answer = cntList.stream().mapToInt(i -> i).toArray(); 
        
        return answer;
    }
}