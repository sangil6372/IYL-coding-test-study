class Solution {
    public int solution(String my_string, String target) {
        
        return my_string.matches(".*"+target+".*")?1:0;
        
    }
}