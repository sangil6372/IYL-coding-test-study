class Solution {
    static String[] words = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;

        for (String b : babbling) {
            if (isPossible("", b)) {
                answer++;
            }
        }

        return answer;
    }

    // 백트래킹 함수
    public boolean isPossible(String now, String target) {
        if (now.equals(target)) return true;
        if (!target.startsWith(now)) return false;

        for (int i = 0; i < 4; i++) {
            if (isPossible(now + words[i], target)) {
                return true;
            }
        }

        return false;
    }
}
