import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 정수 n을 입력받는다
 * 3. n*n을 출력한다
 *
 */

public class Solution {

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 0; tc < testCase; tc++) { // 각 테스트 케이스 별로
			int n = Integer.parseInt(br.readLine().trim()); // 정수 n을 입력받는다
			sb.append("#").append(tc + 1).append(" ").append(n * n).append("\n"); // n^2을 출력
		}
		
		System.out.println(sb);
	}

}
