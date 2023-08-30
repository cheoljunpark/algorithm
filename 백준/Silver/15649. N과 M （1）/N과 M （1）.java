import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 정수(numberSize)와 고를 개수 (selectCount)를 입력받는다
 * 2. 크기 numberSize인 배열(numberList)를 생성
 * 3. numberList에 1부터 numberSize까지 저장한다
 * 4. 순열 메소드를 호출할 때 필요한 방문체크배열(visited)와 고른 것을 담을 배열(selectList)를 생성 
 * 5. 순열 메소드 호출 -> numberSize_P_selectCount를 구한다
 *
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringBuilder sb = new StringBuilder(); // 출력
	static StringTokenizer st; // 토큰화
	static int numberSize; // 정수
	static int[] numberList; // 1 ~ numberSize까지 담을 배열
	static int selectCount; // 고를 개수
	static int[] selectList; // 고른 것 담을 배열
	static boolean[] visited; // 방문 체크

	static void permutation(int selectCountIdx) {
		// 기저 조건
		if (selectCountIdx == selectCount) { // selectCount개 만큼 골랐다면
			for (int selectNumber : selectList) { // selectList에 있는 원소들 append
				sb.append(selectNumber).append(" ");
			}
			sb.append("\n");
			return;
		}

		// 진행 조건
		for (int idx = 0; idx < numberList.length; idx++) {

			// 방문했다면 스킵
			if (visited[idx]) {
				continue;
			}

			// 빙문하지 않았다면 아래 로직 수행
			visited[idx] = true; // 방문 처리하고
			selectList[selectCountIdx] = numberList[idx]; // 원소를 골라 리스트에 넣고
			permutation(selectCountIdx + 1); // 다음 순열 재귀 호출
			visited[idx] = false; // 기저 조건 처리 후 방문 처리한것을 다시 풀기
		}

	}

	public static void main(String[] args) throws IOException {

		// 정수(numberSize)와 고를 개수 (selectCount)를 입력받기
		st = new StringTokenizer(br.readLine().trim());
		numberSize = Integer.parseInt(st.nextToken());
		selectCount = Integer.parseInt(st.nextToken());

		// 크기 numberSize인 배열(numberList) 생성
		numberList = new int[numberSize];

		// numberList에 1부터 numberSize까지 저장한다
		for (int idx = 0; idx < numberList.length; idx++) {
			numberList[idx] = idx + 1;
		}

		// 방문 체크(visited) 생성
		visited = new boolean[numberSize];

		// 고른 것을 담을 배열 생성
		selectList = new int[selectCount];

		// 순열 메소드 호출
		permutation(0);

		// 정답 출력
		System.out.println(sb);
	}

}
