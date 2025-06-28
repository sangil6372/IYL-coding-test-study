import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken()), y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken()), y2 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken()), y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken()), y4 = Long.parseLong(st.nextToken());

        int a = ccw(x1, y1, x2, y2, x3, y3);
        int b = ccw(x1, y1, x2, y2, x4, y4);
        int c = ccw(x3, y3, x4, y4, x1, y1);
        int d = ccw(x3, y3, x4, y4, x2, y2);

        boolean intersect = false;

        if (a * b == 0 && c * d == 0) {
            // 일직선상 colinear일 때 → 실제로 겹치는지 확인
            if (overlap(x1, y1, x2, y2, x3, y3, x4, y4)) {
                intersect = true;
            }
        } else if (a * b <= 0 && c * d <= 0) {
            intersect = true;
        }

        bw.write((intersect ? "1" : "0") + "\n");
        bw.flush();
    }

    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long result = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if (result > 0) return 1;     // 반시계
        else if (result < 0) return -1; // 시계
        else return 0;                 // 일직선
    }

    static boolean overlap(long x1, long y1, long x2, long y2,
                           long x3, long y3, long x4, long y4) {
        long minX1 = Math.min(x1, x2), maxX1 = Math.max(x1, x2);
        long minY1 = Math.min(y1, y2), maxY1 = Math.max(y1, y2);
        long minX2 = Math.min(x3, x4), maxX2 = Math.max(x3, x4);
        long minY2 = Math.min(y3, y4), maxY2 = Math.max(y3, y4);

        return !(maxX1 < minX2 || maxX2 < minX1 || maxY1 < minY2 || maxY2 < minY1);
    }
}
