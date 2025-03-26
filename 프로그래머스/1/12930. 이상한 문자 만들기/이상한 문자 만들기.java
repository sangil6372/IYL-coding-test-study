class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        for (char c : s.toCharArray()){
            if (c == ' ') {
                sb.append(" ");
                i = 0;
                continue;
            }
            sb.append(i%2==0?Character.toUpperCase(c):Character.toLowerCase(c));
            i++;
        }
        return sb.toString();
    }
}