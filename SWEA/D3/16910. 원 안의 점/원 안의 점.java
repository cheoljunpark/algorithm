import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 원의 반지름(radius)를 입력받는다
 * 3. 원 안에 격자점의 개수를 출력한다
 * 4. 검사 방법
 *    - -radius ~ radius까지 (0,0) 과의 거리가 radius보다 작거나 같으면 ok
 *
 */

public class Solution {

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= testCase; tc++) {
			// 원의 반지름 입력받기
			int radius = Integer.parseInt(br.readLine().trim());

			// 격자점의 개수 변수
			int cnt = 0;

			// 검사
			for (int x = -radius; x <= radius; x++) {
				for (int y = -radius; y <= radius; y++) {
					if (Math.sqrt((x - 0) * (x - 0) + (y - 0) * (y - 0)) <= (double) radius) {
						cnt++;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);
	}

}
