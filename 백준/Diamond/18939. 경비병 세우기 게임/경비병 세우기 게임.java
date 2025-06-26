import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    StringBuilder sb = new StringBuilder();

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long N = Long.parseLong(st.nextToken());
      long M = Long.parseLong(st.nextToken());
      long K = Long.parseLong(st.nextToken());

      if (M < 2 * K) {
    	// 선공이 즉시 한 칸만 채워도 안전 상태가 되어 Yuto가 이김
        sb.append("Yuto\n");
      } else {
    	// 격자면적에서 2×K×K만큼은 “2개의 K×K가 겹치지 않도록 배치되는 영역”으로 남게 됨
        long rem = N * M - 2 * K * K;
        sb.append((rem % 2 != 0) ? "Yuto\n" : "Platina\n");
      }
    }

    System.out.print(sb);
  }
}
