import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 10개의 수를 입력받을 배열 선언한다
 * 3. 10개의 수를 입력받아 배열에 저장한다
 * 4. 10개의 수를 입력받으면서 최댓값과 최솟값의 인덱스를 구한다
 * 5. 배열에서 최댓값과 최솟값을 제외하고 나머지의 평균값을 구한다
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

		for (int tc = 1; tc <= testCase; tc++) { // 각 테스트 케이스별로

			// 배열 선언
			numList = new int[10];

			// 최댓값, 최솟값 저장 변수 선언
			int maxVal = Integer.MIN_VALUE;
			int minVal = Integer.MAX_VALUE;

			// 최댓값 인덱스, 최솟값 인덱스 저장 변수 선언
			int maxValIdx = 0;
			int minValIdx = 0;

			// 10개의 수 입력받기
			// 입력받으면서 최댓값, 최솟값 정보 찾기
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < numList.length; idx++) {
				numList[idx] = Integer.parseInt(st.nextToken());

				if (numList[idx] > maxVal) { // 최댓값 찾기
					maxValIdx = idx;
					maxVal = numList[idx];
				}

				if (numList[idx] < minVal) { // 최솟값 찾기
					minValIdx = idx;
					minVal = numList[idx];
				}
			}

			// 최댓값, 최솟값 제외하고 평균 구하기
			int sum = 0;
			double avg;

			for (int idx = 0; idx < numList.length; idx++) {
				if (idx == maxValIdx || idx == minValIdx) {
					continue;
				}
				sum += numList[idx];
			}

			avg = (double) sum / (numList.length - 2);

			// 평균값 append
			sb.append("#").append(tc).append(" ").append(Math.round(avg)).append("\n");
		}
		
		// 정답 출력
		System.out.println(sb);
	}

}
