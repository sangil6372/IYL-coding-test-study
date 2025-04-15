class Solution {
   	static int maxDepth; 
	static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
    
        maxDepth = 0;
        visited = new boolean[dungeons.length];
        
        dfs(dungeons, 0, k );
        
        return maxDepth;
    }
    
    
    public void dfs (int[][] dungeons, int depth, int k) {
        maxDepth = Math.max(maxDepth, depth);
        
        for (int i = 0 ; i < dungeons.length; i++){
            if (!visited[i]&&dungeons[i][0]<=k){
                visited[i] = true;
                dfs(dungeons, depth+1, k-dungeons[i][1]); // 소모 피로도 만큼 빼야함
                visited[i] = false; // backtracking
            }
        }
    }
}