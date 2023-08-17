import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 문자열을 입력받는다
 * 3. 문자열을 문자단위로 나눈다
 * 4. 분자=1, 분모=1로 설정한다
 * 5. 문자가 'L'이면 "분모 = 분자+분모"를 한다
 *    문자가 'R'이면 "분자 = 분자+분모"를 한다
 * 6. 분자와 분모를 출력한다. 
 *
 */

public class Solution {

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());

		// 각 테스트 케이스별로
		for (int tc = 1; tc <= testCase; tc++) {
			char[] arr = br.readLine().trim().toCharArray(); // 입력받은 문자열 문자 단위로 쪼개기

			int molecule = 1; // 분자
			int denominator = 1; // 분모

			for (char ch : arr) {
				if (ch == 'L') { // 문자가 'L'이면
					denominator = molecule + denominator; // 분모 = 분자 + 분모
				} else { // 문자가 'R'이면
					molecule = molecule + denominator; // 분자 = 분자 + 분모
				}
			}

			sb.append("#").append(tc).append(" ").append(molecule).append(" ").append(denominator).append("\n");
		}

		System.out.println(sb);
	}

}
