import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String encodedString = br.readLine();
			String decodeString = decodeBase64(encodedString);
			
			sb.append("#" + test_case + " " + decodeString + "\n");
		}
		System.out.println(sb);
	}
    public static String decodeBase64(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return new String(decodedBytes);
    }

}