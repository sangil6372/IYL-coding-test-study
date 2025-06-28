public class Main {
    public static void main(String[] args) {
        int[][] table = new int[30][30];

        for (int i = 0; i < 15; i++) {
            table[15][14 - i] = 1;
            table[14 - i][15] = 1 * 16;
            table[15][15 + i] = 1 * 16 * 16;
            table[15 + i][15] = 1 * 16 * 16 * 15;
            table[15][15] = 0;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                sb.append(table[i][j]);
                if (j != 29) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
