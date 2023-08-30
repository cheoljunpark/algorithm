import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스(testCase) 는 10개다
 * 2. 각 테스트 케이스마다 크기 100의 상자 배열(boxes)를 생성
 * 3. 덤프 횟수(dumpCount)를 입력받는다
 * 4. boxes에 값 입력
 * 5. 덤프 횟수(dumpCount)만큼 반복해서
 * 6. 박스 배열을 정렬해 최댓값(box[99])은 -1 하고, 최솟값(box[0])은 +1 한다
 * 7. 마지막으로 정렬한 뒤 최댓값과 최솟값의 차를 출력
 *
 */

public class Solution {
	static int testCase = 10; // 테스트 케이스 개수
	static final int BOX_COUNT = 100; // 박스 개수 100개
	static int[] box; // 박스 배열
	static int dumpCount; // 덤프 횟수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringBuilder sb = new StringBuilder(); // 출력
	static StringTokenizer st; // 토큰화

	public static void main(String[] args) throws IOException {

		// 각 테스트케이스마다
		for (int tc = 1; tc <= testCase; tc++) {

			// 덤프 횟수 입력 받기
			dumpCount = Integer.parseInt(br.readLine().trim());

			// 박스 배열 생성
			box = new int[BOX_COUNT];

			// box 입력 받기
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < box.length; idx++) {
				box[idx] = Integer.parseInt(st.nextToken());
			}

			// dumpCount 횟수 만큼 반복해서
			// 박스 배열을 정렬
			// box[0](최솟값)++, box[99](최댓값)-- 하기
			for (int cnt = 0; cnt < dumpCount; cnt++) {
				Arrays.sort(box);
				box[0]++;
				box[99]--;
			}

			// 최댓값과 최솟값의 차이 출력
			Arrays.sort(box);
			sb.append("#").append(tc).append(" ").append(box[99] - box[0]).append("\n");
		}

		System.out.println(sb);
	}

}
