import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 10개의 정수를 입력받아 배열에 담는다
 * 3. 최댓값을 구한다.
 *
 */

public class Solution {
	static int testCase;
	static int[] numList;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		// 테스트 케이스 입력받기
		testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= testCase; tc++) { // 각 테스트 케이스 별로

			// 10개의 정수를 입력받을 배열 선언
			numList = new int[10];

			// 10개의 정수 입력받기
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < 10; idx++) {
				numList[idx] = Integer.parseInt(st.nextToken());
			}

			// 최댓값 저장 변수 선언
			int maxVal = Integer.MIN_VALUE;

			// 최댓값 찾기
			for (int idx = 0; idx < numList.length; idx++) {
				if (numList[idx] > maxVal) {
					maxVal = numList[idx];
				}
			}

			// 최댓값 append
			sb.append("#").append(tc).append(" ").append(maxVal).append("\n");

		}

		// 정답 출력
		System.out.println(sb);
	}

}
