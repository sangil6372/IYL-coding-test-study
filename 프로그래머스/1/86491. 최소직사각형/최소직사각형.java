class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
//      그냥 둘 중에 더 작은 걸 세로라고 치자 
//      영역을 <-> 로 갱신 해 나가야 함 
        int maxW = 0;
        int maxH = 0; 
        
        for (int[] size : sizes ){
            int w = Math.max(size[0],size[1]);
            int h = Math.min(size[0],size[1]);
        
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        answer = maxW * maxH;
        
        return answer;
    }
}