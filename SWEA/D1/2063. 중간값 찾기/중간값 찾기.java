import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 입력받는 점수의 개수(gradeCnt)를 입력받는다
 * 2. 크기가 gradeCnt인 배열 gradeList를 생성
 * 3. 점수를 입력받아 gradeList에 저장
 * 4. gradeList를 정렬
 * 5. gradeList[gradeCnt/2]를 출력
 *
 */

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		// 입력받는 점수의 개수(gradeCnt)를 입력받는다
		int gradeCnt = Integer.parseInt(br.readLine().trim());

		// 크기가 gradeCnt인 배열 gradeList를 생성
		int[] gradeList = new int[gradeCnt];

		// 점수를 입력받아 gradeList에 저장
		st = new StringTokenizer(br.readLine().trim());
		for (int idx = 0; idx < gradeList.length; idx++) {
			gradeList[idx] = Integer.parseInt(st.nextToken());
		}

		// gradeList를 정렬
		Arrays.sort(gradeList);

		// gradeList[gradeCnt/2]를 출력
		System.out.println(gradeList[gradeCnt / 2]);
	}

}
