import java.util.Scanner;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 통나무 길이(n)을 입력받는다
 * 3. 계속 1미터로 자르고 Alice부터 자르므로
 *    n이 짝수면 결국 Alice가 더 이상 자를 수 없게 되고
 *    n이 홀수면 결국 Bob이 더 이상 자를 수 없게 된다
 *
 */

public class Solution {

	public static void main(String[] args) {
		// 출력
		StringBuilder sb = new StringBuilder();

		// 입력
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 입력받기
		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) { // 각 테스트 케이스 별로
			int n = sc.nextInt(); // 통나무 길이(n)을 입력받고

			if (n % 2 == 0) { // n이 짝수면 Alice 출력
				sb.append("#").append(tc).append(" ").append("Alice").append("\n");
			} else { // n이 홀수면 Bob 출력
				sb.append("#").append(tc).append(" ").append("Bob").append("\n");
			}

		}

		System.out.println(sb);
	}

}
