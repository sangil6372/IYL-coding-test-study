class Solution {
    public int solution(String s) {
        int answer = s.length();
        
//      1개 단위 ~ n/2개 단위 압축 
//      stack ? StringBuilder ?
// 문자열 자르기 -> substring
        
        for (int unit = 1; unit <=s.length()/2 ; unit++){
            answer = Math.min(answer, compress(s, unit));
        }
        
        return answer;
    }
    
    public int compress(String s, int unit){
        StringBuilder sb = new StringBuilder();
        
//      0부터 n-1 까지 초기 문자열 
        String prev = s.substring(0,unit);
        int count = 1;
        for (int i = unit; i <= s.length(); i+=unit ){
            int endIdx = Math.min(s.length(), i+unit);
            String compare = s.substring(i, endIdx);
            if (prev.equals(compare)){
                count++;
            }else{
//                다르면? 기존 거 일단 붙임 ?
                if (count>=2){
                    sb.append(count);
                }
                sb.append(prev);
                prev = compare;
                count = 1;
            }
        }
        sb.append(prev); // 마지막은 무조건 붙여야 함 

        return sb.length();
    }
}