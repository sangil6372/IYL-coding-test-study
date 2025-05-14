import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int result;
    static int N,K;
    static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		
		int[][] board = new int[9][9];

        // 스도쿠 퍼즐 입력 받기
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        
        solve(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
	}    

    public static boolean solve(int[][] board) {
    	for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
            	if (board[row][col]==0) {
            		for (int num = 1; num <=9; num++) {
//            			유효한 경우에만 재귀 호출
            			if (isValid(board,row,col,num)) {
            				board[row][col] = num;
            				if (solve(board)) {
                                return true;
                            }
            				board[row][col] = 0; //bt
            			}
            		}
                    return false; // 가능한 숫자가 없으면 false 반환            		
            	}
            } 
    	}
    	return true;
    }
    public static boolean isValid(int[][] board, int row, int col, int num) {
//    	행, 열, 3x3 격자 검사 
    	for (int i = 0; i < 9; i++) {
			if (board[row][i] == num) return false;
			if (board[i][col] == num) return false;
			// 같은 3x3 격자 안에 같은 숫자가 있는지 검사
            if (board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
		}
    	return true;
    }
}

