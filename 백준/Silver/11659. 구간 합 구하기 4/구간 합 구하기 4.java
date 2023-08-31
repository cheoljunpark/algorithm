import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 수의 개수(numberCount), 연산 횟수(calculateCount)를 입력받는다
 * 2. 크기가 (numberCount+1)인  누적합 저장 배열(cumulativeSumList)를 생성
 * 3. cumulativeSumList를 입력받는다(각 인덱스에는 누적합을 저장한다)
 * 4. calculateCount 횟수 만큼 두 수(firstIdx, secondIdx)를 입력받는다
 * 5. numberList[firstIdx] - numberList[secondIdx]를 구해서 출력한다
 * 
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringBuilder sb = new StringBuilder(); // 출력
	static StringTokenizer st; // 토큰화
	static int numberCount, calculateCount; // 수의 개수, 연산 횟수
	static int[] cumulativeSumList; // 입력 받은 수의 누적합을 저장할 배열
	static int firstIdx, secondIdx; // firstIdx번째 수, secondIdx번째 수

	public static void main(String[] args) throws IOException {

		// 수의 개수, 연산 횟수 입력받기
		st = new StringTokenizer(br.readLine().trim());
		numberCount = Integer.parseInt(st.nextToken());
		calculateCount = Integer.parseInt(st.nextToken());

		// 숫자를 저장할 크기 numberCount인 배열 생성
		cumulativeSumList = new int[numberCount + 1];

		// numberList에 숫자 입력받기
		st = new StringTokenizer(br.readLine().trim());
		for (int idx = 1; idx <= numberCount; idx++) {
			cumulativeSumList[idx] = cumulativeSumList[idx - 1] + Integer.parseInt(st.nextToken());
		}

		// 연산 횟수 만큼 연산 하기
		for (int calculate = 0; calculate < calculateCount; calculate++) {
			st = new StringTokenizer(br.readLine().trim());
			firstIdx = Integer.parseInt(st.nextToken());
			secondIdx = Integer.parseInt(st.nextToken());

			// firstIdx번째 수부터 secondIdx번째 수까지의 합 append
			// -> numberList[secondIdx] - numberList[firstIdx-1] append
			sb.append(cumulativeSumList[secondIdx] - cumulativeSumList[firstIdx - 1]).append("\n"); // 누적합 append
		}

		// 정답 출력
		System.out.println(sb);
	}

}
