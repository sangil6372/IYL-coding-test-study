import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> result = new ArrayDeque<>();

        int n = board.length;
        List<Deque<Integer>> toyCols = new ArrayList<>();

        for (int c = 0; c < n; c++) {
            Deque<Integer> col = new ArrayDeque<>();
            for (int r = 0; r < n; r++) {
                if (board[r][c] != 0) {
                    col.addLast(board[r][c]); 
                }
            }
            toyCols.add(col);
        }

        for (int move : moves) {
            int colIdx = move - 1;
            if (toyCols.get(colIdx).isEmpty()) continue;

            int picked = toyCols.get(colIdx).pollFirst(); 

            if (!result.isEmpty() && result.peekLast() == picked) {
                result.removeLast();
                answer += 2;
            } else {
                result.addLast(picked);
            }
        }

        return answer;
    }
}
