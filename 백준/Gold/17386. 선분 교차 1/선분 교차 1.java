import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        int a = ccw(x1, y1, x2, y2, x3, y3);
        int b = ccw(x1, y1, x2, y2, x4, y4);
        int c = ccw(x3, y3, x4, y4, x1, y1);
        int d = ccw(x3, y3, x4, y4, x2, y2);

        if (a * b < 0 && c * d < 0) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // ccw가 무조건 -1 (반시계) 혹은 1 (시계) 반환
    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long result = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        return result < 0 ? 1 : -1;
    }
}
