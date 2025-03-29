class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        String[] input = s.toLowerCase().split(" ", -1);
        
        for (String str : input){
            if (!str.isEmpty()){
                sb.append(Character.toUpperCase(str.charAt(0)));
                sb.append(str.substring(1));   
            }
            sb.append(" ");
        }
        
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}