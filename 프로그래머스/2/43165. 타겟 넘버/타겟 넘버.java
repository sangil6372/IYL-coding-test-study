import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    public int dfs(int[] numbers , int target , int idx , int curr){
        if (idx == numbers.length){
            return (curr==target) ? 1 : 0 ;
        }
        int sum = 0;
        sum += dfs(numbers, target, idx+1, curr+numbers[idx]);
        sum += dfs(numbers, target, idx+1, curr-numbers[idx]);
        
        return sum;
    }
    
}