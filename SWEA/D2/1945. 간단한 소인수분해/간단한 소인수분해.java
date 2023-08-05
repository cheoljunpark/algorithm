import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 정수(n)을 입력받는다
 * 3. 2,3,5,7,11의 개수인 5크기의 배열(cnt)을 선언한다
 * 4. n을 각각 2,3,5,7,11로 나머지가 안 생길때까지의 나눈 횟수를 저장한다
 *
 */

public class Solution {

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 입력받기
		int testCase = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 마다
		for (int tc = 0; tc < testCase; tc++) {
			int n = Integer.parseInt(br.readLine().trim());	// 정수(n) 입력받기
			int[] cnt = new int[5];	// 2,3,5,7,11 횟수 담을 배열
			int idx = 0;	// cnt의 인덱스를 순회할 변수
			
			// 나머지가 없을때 까지 2로 나누기
			while (true) {
				if (n % 2 != 0) {
					idx++;
					break;
				}
				n /= 2;
				cnt[idx]++;
			}
			
			// 나머지가 없을때 까지 3로 나누기
			while (true) {
				if (n % 3 != 0) {
					idx++;
					break;
				}
				n /= 3;
				cnt[idx]++;
			}
			
			// 나머지가 없을때 까지 5로 나누기
			while (true) {
				if (n % 5 != 0) {
					idx++;
					break;
				}
				n /= 5;
				cnt[idx]++;
			}
			
			// 나머지가 없을때 까지 7로 나누기
			while (true) {
				if (n % 7 != 0) {
					idx++;
					break;
				}
				n /= 7;
				cnt[idx]++;
			}
			
			// 나머지가 없을때 까지 11로 나누기
			while (true) {
				if (n % 11 != 0) {
					idx++;
					break;
				}
				n /= 11;
				cnt[idx]++;
			}

			sb.append("#").append(tc + 1);
			for (int i = 0; i < cnt.length; i++) {
				sb.append(" ").append(cnt[i]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
