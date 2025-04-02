import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		List<Integer> list = new ArrayList<>();
		for (String s : input) {
			list.add(Integer.parseInt(s));
		}
		
		Collections.sort(list);

//		(N-순번) 만큼 자신의 이용 시간이 누적됨 ㅇㅇ <- (N-i)*arr[i번째]
		
//		쉽게 말하면 친구들끼리 여행가서 씻을 때 빨리 씻는 사람 먼저 씻는 느낌
//		근데 씻는 사람을 기다리는 사람들은 다음 사람만 해당 되는게 아니라 모든 아직 안 씻은 사람들임
//		총 소요 시간이라 본인 씻는 시간까지 고려 (N-i-1)가 아니라  (N-i)본인 포함
		int answer = 0;
		for (int i = 0 ; i <input.length; i++ ) {
			answer += (N-i)*list.get(i);
		}

		System.out.println(answer);
	}
}
