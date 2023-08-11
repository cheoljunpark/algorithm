import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 *
 * 1. 과일의 개수(n)과 스네이크버드의 초기 길이(snakebirdSize)를 입력받는다
 * 2. n개의 과일의 높이를 담을 배열(fruitHeight)을 선언한다
 * 3. fruitHeight에 각 과일의 높이를 입력받는다
 * 4. fruitHeight를 정렬한다
 * 5. fruitHeight의 각 요소를 돌며 검사
 *    5.1 각 요소의 값이 snakebirdSize보다 작거나 같으면 snakebirdSize값 1만큼 증가
 *    5.2 요소의 값이 snakebirdSize보다 크다면 탈출
 * 6. snakebirdSize 값 출력
 * 
 */

public class Main {

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 과일의 개수(n)과 스네이크버드의 초기 길이(snakebirdSize)를 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int snakebirdSize = Integer.parseInt(st.nextToken());

		// n개의 과일의 높이를 담을 배열 선언
		int[] fruitHeight = new int[n];

		// 각 과일의 높이 입력받기
		st = new StringTokenizer(br.readLine().trim());
		for (int idx = 0; idx < fruitHeight.length; idx++) {
			fruitHeight[idx] = Integer.parseInt(st.nextToken());
		}

		// 과일의 높이 정렬하기
		Arrays.sort(fruitHeight);

		// 검사
		for (int height : fruitHeight) {
			if (height <= snakebirdSize) {
				snakebirdSize++;
			} else {
				break;
			}
		}

		// 스네이크버드 길이 출력
		System.out.println(snakebirdSize);
	}

}
