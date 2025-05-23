class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        // 풀이를 기억하지말고 생각 ㄱㄱ
        
        int sum  = sequence[0];
        int s = 0;
        int e = 0;
        
        int minLength = Integer.MAX_VALUE;
        while ( s <= e && e < sequence.length){
            if (sum < k){
                if (++e < sequence.length) {
                    sum += sequence[e];
                }
            }else if (sum > k){
                sum -= sequence[s];
                s++;
            }else {
                // 만약 구한다면? 바로 리턴 ? ㄴㄴ
                if (e-s < minLength){
                    minLength = e-s;
                    answer[0] = s;
                    answer[1] = e;
                } 
                sum -= sequence[s++];
            }
        }
        

        
        
        
        return answer;
    }
}