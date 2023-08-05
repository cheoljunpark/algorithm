import java.util.Scanner;

/**
 * 
 * @author 박철준
 * 
 * 1. 정수(n)을 입력받는다
 * 2. 반복문을 돌면서 1부터 n까지
 * 3. 문자열로 변환해 문자열안에 3, 6, 9가 있는지 확인
 * 4. 있는지 확인하면서 3, 6, 9의 개수를 조사
 * 5. 개수만큼 "-" 출력
 *
 */

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 정수 입력받기

		// 1부터 n까지
		for (int i = 1; i <= n; i++) {
			String str = String.valueOf(i); // 정수를 String으로 변환해서

			// 정수안에 3, 6, 9가 있는지 확인하기
			int cnt = 0; // 3,6,9의 개수
			for (int idx = 0; idx < str.length(); idx++) {
				if (str.charAt(idx) == '3' || str.charAt(idx) == '6' || str.charAt(idx) == '9')
					cnt++;

			}

			if (cnt == 0) { // 3,6,9가 없었다면
				System.out.print(i + " ");
			} else { // 3,6,9가 있었다면
				for (int idx = 0; idx < cnt; idx++) {
					System.out.print("-"); // 개수만큼 "-" 출력
				}
				System.out.print(" ");
			}

		}
	}

}
