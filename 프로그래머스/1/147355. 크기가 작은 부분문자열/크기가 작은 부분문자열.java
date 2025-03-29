class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int strLength = p.length();
        for (int i = 0 ; i < t.length() - strLength + 1; i++ ){
            String subStr = t.substring(i, i + strLength);
            if (subStr.compareTo(p) <= 0) answer++;
        }
        
        
        return answer;
    }
}