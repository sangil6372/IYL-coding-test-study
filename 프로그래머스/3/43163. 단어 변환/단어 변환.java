import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
//     최소 단계? -> BFS 

//      한 번에 하나의 단어로 변경 가능함 
//      단어 하나만 차이가 날 경우 연결 된 것 
//      굳이 Integer 형태로 변경해야 하나? -> 차라리 Set에 담고 단어 하나가 차이 나는 경우를 체크 할 수 있나?
        visited = new boolean[words.length];
        answer = bfs(begin, words, target);    
    
        
        return answer;
    }
    public static int bfs(String str, String[] words, String target){
        
        Queue<String> queue = new LinkedList<>();
        queue.add(str);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for( int i = 0; i < size; i++){
                String curStr = queue.poll();
                
                if (curStr.equals(target)) return depth;
                
                
                for (int j = 0; j < words.length; j++){
//                  방문 안했고 연결 되어있으면 ㄱ
                    String nextStr = words[j];
                    if (!visited[j]&&canConvert(curStr, nextStr)){
                        visited[j] = true;
                        queue.add(nextStr);
                    } 
                }
            }
//          첫 시작은 카운트 X
            depth++;
        }
        return 0;
        
    }
    
    
//  연결 여부 판단하는함수 
    public static boolean canConvert(String str1, String str2){
//  한 글자만 다른지 
        int diffCnt = 0;
        for(int i = 0; i < str1.length(); i++){
            if (str1.charAt(i)!=str2.charAt(i)) {
                diffCnt++;
                if (diffCnt > 1) return false;
            }
        }
        if (diffCnt==1) return true;
        return false;
    }
    
    
    
}