import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스 별로 재료의 수(ingredientCnt)과 제한 칼로리(calorieLimit)을 입력받는다
 * 3. 각 재료의 점수(ingredientScore)와 칼로리(ingredientCalorie)를 입력받는다
 * 4. 재료의 부분집합 중 제한 칼로리 이하이면서, 점수가 가장 높은 햄버거의 점수를 출력한다
 *
 */

class Ingredient {
	int ingredientScore;
	int ingredientCalorie;

	Ingredient(int ingredientScore, int ingredientCalorie) {
		this.ingredientScore = ingredientScore;
		this.ingredientCalorie = ingredientCalorie;
	}
}

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int ingredientCnt;
	static int calorieLimit;
	static Ingredient[] ingredientList;
	static boolean[] visited;
	static int maxScore = 0;

	static void powerSet(int n) {
		int sumScore = 0;
		int sumCalorie = 0;

		if (n == ingredientCnt) {
			for (int idx = 0; idx < ingredientCnt; idx++) {
				if (visited[idx]) {
					sumScore += ingredientList[idx].ingredientScore;
					sumCalorie += ingredientList[idx].ingredientCalorie;
				}
			}

			if (sumCalorie <= calorieLimit) {
				maxScore = Math.max(maxScore, sumScore);
			}
			return;
		}

		visited[n] = true;
		powerSet(n + 1);

		visited[n] = false;
		powerSet(n + 1);
	}

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트 케이스 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());

		// 각 테스트 케이스 별로 재료의 수(ingredientCnt)과 제한 칼로리(calorieLimit)을 입력받기
		for (int tc = 0; tc < testCase; tc++) {
			maxScore = 0;
			st = new StringTokenizer(br.readLine().trim());
			ingredientCnt = Integer.parseInt(st.nextToken());
			calorieLimit = Integer.parseInt(st.nextToken());

			// ingredientCnt 크기의 배열 만들기
			ingredientList = new Ingredient[ingredientCnt];

			// 각 재료의 점수(ingredientScore)와 칼로리(ingredientCalorie)를 입력받기
			for (int ingredientIdx = 0; ingredientIdx < ingredientCnt; ingredientIdx++) {
				st = new StringTokenizer(br.readLine().trim());
//				ingredientList[ingredientIdx].ingredientScore = Integer.parseInt(st.nextToken()); // 각 재료의 점수
//				ingredientList[ingredientIdx].ingredientCalorie = Integer.parseInt(st.nextToken()); // 각 재료의 칼로리
				int ingredientScore = Integer.parseInt(st.nextToken());
				int ingredientCalorie = Integer.parseInt(st.nextToken());
				ingredientList[ingredientIdx] = new Ingredient(ingredientScore, ingredientCalorie);
			}

			visited = new boolean[ingredientCnt];

			powerSet(0);

			sb.append("#").append(tc + 1).append(" ").append(maxScore).append("\n");
		}

		// 출력
		System.out.println(sb);
	}

}
