import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스 별로 규영이의 숫자 9개를 입력받는다
 * 3. 1 ~ 18 사이의 수 중에서 규영이의 숫자 9개를 뺀 수를 인영이의 숫자로 만든다.
 * 4. 인영이의 숫자 9개중 순열 9P9를 사용해 규영이의 숫자들과 비교해 점수를 측정한다.
 * 5. 그렇다면 게임은 총 9P9번 == 9!번 만큼 하는거니까 9!번의 게임 중
 *    이기는 경우와 지는 경우를 계산한다
 *
 */

public class Solution {
	static int[] kyuyoungCard;	// 규영 카드
	static int[] inyoungCard;	// 민영 카드
	static ArrayList<Integer> numList;	//	1~18 사이의 수 중에서 규영이가 고른 카드를 제외한 숫자를 담을 리스트
	static boolean[] visited;	// 방문 체크
	static int win;	// 승 카운트 변수
	static int lose;	// 패 카운트 변수

	public static void permutation(int depth) {
		if (depth == 9) {
			int kyuyoungScore = 0;
			int inyoungScore = 0;

			for (int i = 0; i < 9; i++) {
				if (kyuyoungCard[i] > inyoungCard[i]) {
					kyuyoungScore += kyuyoungCard[i] + inyoungCard[i];
				} else if (kyuyoungCard[i] < inyoungCard[i]) {
					inyoungScore += kyuyoungCard[i] + inyoungCard[i];
				}
			}

			if (kyuyoungScore > inyoungScore)	// 규영이가 민영이보다 총합이 크다면
				win++;	// 승
			else	// 민영이가 규영이보다 총합이 크다면
				lose++;	// 패

			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				inyoungCard[depth] = numList.get(i);
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테스트 케이스 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 0; tc < testCase; tc++) { // 각 테스트 케이스 별로
			// 카드 정보
			kyuyoungCard = new int[9];
			inyoungCard = new int[9];
			numList = new ArrayList<>();
			visited = new boolean[9];

			win = 0;
			lose = 0;

			// 규영이 수 입력받기
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < 9; idx++) {
				kyuyoungCard[idx] = Integer.parseInt(st.nextToken());
			}
			
			// 1 ~ 18 리스트에 넣기
			for (int i = 1; i <= 18; i++) {
				numList.add(i);
			}
			
			// 리스트에서 규영이가 고른 숫자 빼기
			for (int i : kyuyoungCard) {
				numList.remove(Integer.valueOf(i));
			}

			permutation(0);

			sb.append("#").append(tc + 1).append(" ").append(win).append(" ").append(lose).append("\n");
		}

		System.out.println(sb);
	}

}
