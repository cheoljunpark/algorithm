import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 재료의 개수(ingredientCount)를 입력받는다
 * 2. 각 재료마다 신맛(sour)과 쓴맛(bitter)을 각각 입력받는다
 * 3. 각 재료를 재료리스트(ingredientList)에 넣는다
 * 4. 각 재료의 부분집합을 구해 신맛과 쓴맛의 최소 차이를 구한다
 * 
 */

public class Main {
	static int ingredientCount;
	static Ingredient[] ingredientList;
	static boolean[] visited;
	static int sourMinusBitter;
	static int minSourMinusBitter = 1000000000;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class Ingredient { // 재료 클래스
		int sour;
		int bitter;

		public Ingredient(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	}

	static void powerSet(int selectIdx) { // 부분집합 메소드
		// 기저 조건
		// 모두 선택 했다면
		if (selectIdx == ingredientCount) {
			int sourTotal = 1; // 각 재료의 신맛을 곱할 것이기 때문에 1으로 초기화
			int bitterTotal = 0; // 각 재료의 쓴맛을 더할 것이기 때문에 0으로 초기화
			for (int ingredientIdx = 0; ingredientIdx < ingredientCount; ingredientIdx++) {
				if (visited[ingredientIdx]) {
					sourTotal *= ingredientList[ingredientIdx].sour;
					bitterTotal += ingredientList[ingredientIdx].bitter;
				}
			}
			if(sourTotal!=1&&bitterTotal!=0) {
				sourMinusBitter = Math.abs(sourTotal - bitterTotal);
				minSourMinusBitter = Math.min(minSourMinusBitter, sourMinusBitter);
			}
			return;
		}

		// 진행 조건
		visited[selectIdx] = true;
		powerSet(selectIdx + 1);

		visited[selectIdx] = false;
		powerSet(selectIdx + 1);

	}

	public static void main(String[] args) throws IOException {

		// 재료 개수 입력받기
		ingredientCount = Integer.parseInt(br.readLine().trim());

		// 재료 리스트 생성
		ingredientList = new Ingredient[ingredientCount];

		// 방문(고른) 리스트 생성
		visited = new boolean[ingredientCount];

		// 재료 개수 만큼 재료 정보 입력받으면서
		// 재료 리스트에 넣기
		for (int ingredientNumber = 0; ingredientNumber < ingredientCount; ingredientNumber++) {
			st = new StringTokenizer(br.readLine().trim());
			Ingredient ingredient = new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			ingredientList[ingredientNumber] = ingredient;
		}

		// 재료 리스트에서 부분집합을 구해
		// 신맛과 쓴맛의 차이가 최소인 값 구하기
		// 재료가 하나라면 그냥 (신맛-쓴맛)의 절댓값을 구하고, 하나 이상이면 부분집합 메소드 호출
//		if (ingredientCount == 1) {
//			minSourMinusBitter = Math.abs(ingredientList[0].sour - ingredientList[0].bitter);
//		} else {
//			powerSet(0);
//		}
		
		powerSet(0);
		
		// 신맛과 쓴맛 차이의 최소값 출력
		System.out.println(minSourMinusBitter);
	}

}
