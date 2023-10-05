import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 테스트 케이스 번호를 입력받는다
 * 3. 1000개의 점수를 저장할 배열(gradeList)을 생성
 * 4. 각 점수가 나타난 횟수를 저장할 배열(gradeCount)을 생성
 * 5. gradeList에 1000개의 점수를 저장한다
 * 6. gradeList를 순회하면서 나타난 점수를 gradeCount의 인덱스로 삼아 
 *    해당 인덱스의 gradeCount값을 증가
 * 7. gradeCount 리스트의 최댓값의 인덱스 출력
 *
 */

public class Solution {
	static int testCase;
	static int[] gradeList;
	static int[] gradeCount;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		// 테스트 케이스 입력받기
		testCase = Integer.parseInt(br.readLine().trim());

		// 각 테스트 케이스 별로
		for (int tc = 1; tc <= testCase; tc++) {
			// 테스트 케이스 번호 입력받기(의미없음)
			int testCaseNumber = Integer.parseInt(br.readLine().trim());

			// 1000개의 점수를 저장할 배열(gradeList)을 생성
			gradeList = new int[1001];

			// 각 점수가 나타난 횟수를 저장할 배열(gradeCount)을 생성
			gradeCount = new int[101];

			// gradeList에 1000개의 점수를 저장한다
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 1; idx < gradeList.length; idx++) {
				gradeList[idx] = Integer.parseInt(st.nextToken());
			}

			// gradeList를 순회하면서 나타난 점수를 gradeCount의 인덱스로 삼아
			// 해당 인덱스의 gradeCount값을 증가
			for (int idx = 1; idx < gradeList.length; idx++) {
				gradeCount[gradeList[idx]]++;
			}

			// gradeCount 리스트의 최댓값의 인덱스 구하기
			int maxCount = 0;
			int maxCountIdx = 0;
			for (int idx = 1; idx < gradeCount.length; idx++) {
				if (gradeCount[idx] >= maxCount) {
					maxCount = gradeCount[idx];
					maxCountIdx = idx;
				}
			}

			// 최빈수 append
			sb.append("#").append(tc).append(" ").append(maxCountIdx).append("\n");
		}

		// 정답 출력
		System.out.println(sb);
	}

}
