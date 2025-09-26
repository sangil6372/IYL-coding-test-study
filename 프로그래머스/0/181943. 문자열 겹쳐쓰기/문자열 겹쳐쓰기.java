class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        sb.append(my_string.substring(0,s)).append(overwrite_string).append(my_string.substring(s+overwrite_string.length()));
        
        
//         sb.replace(s,s+overwrite_string.length(),overwrite_string);
        
        
        return sb.toString();
    }
}