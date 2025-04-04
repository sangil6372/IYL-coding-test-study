class Solution {
    public int solution(int num) {
        int answer = 0;
    
        if (num == 0) return 0;
        
        long n = num;
        
        while (n!=1){ //  결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다. 
            if ( n%2==0) n/=2; //  1-1. 입력된 수가 짝수라면 2로 나눕니다. 
            else n = n*3+1; //  입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
            answer++;
            if (answer>500) return -1;
        }
        
        return answer;
    }
}