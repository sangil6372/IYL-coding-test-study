import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> scoreList = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			scoreList.add(Integer.parseInt(input[i]));
		}
		double scoreSum = 0;
		int maxScore = Collections.max(scoreList);
		for (double score : scoreList) {
			scoreSum += (double) score / maxScore * 100;
		}

		double scoreAvg = scoreSum / N;
		System.out.println(scoreAvg);
	}
}
