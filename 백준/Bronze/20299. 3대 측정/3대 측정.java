import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. n, k, l을 입력받는다
 * 2. 각 팀마다 세 정수를 입력받는다
 * 3. 조건을 만족하는지 확인한다
 *    - 조건1: 세 정수의 합이 k 이상인지 확인
 *    - 조건2: 세 정수가 모두 l 이상인지 확인
 * 4. 조건을 만족하는 팀의 정수를 각각 출력
 * 
 */

public class Main {
	static int n;	// n: 팀의 수
	static int k;	// k: 팀원 3명의 레이팅 합 조건
	static int l;	// l: 개인 레이팅 조건
	static int checkedTeam = 0; // 조건을 만족한 팀의 수

	// 가입할수 있는지 조건을 체크하는 메소드
	static boolean check(int team[]) {
		int sum = 0; // 개인의 레이팅의 합을 저장할 변수

		for (int individual : team) {
			if (individual < l) { // 개인의 레이팅이 l보다 작다면
				return false; // 조건 만족 X
			}
			sum += individual; // 각 개인의 레이팅 점수를 더한다
		}

		if (sum >= k) { // 팀의 레이팅 점수가 k이상이면
			checkedTeam++;
			return true; // 조건 만족 O
		} else { // k 미만이면
			return false; // 조건 만족 X
		}
	}

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// n, k, l 입력받기
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		// 팀 만들기
		int[][] team = new int[n][3];

		// 각 팀의 개인 레이팅 점수를 입력 받기
		for (int teamNumber = 0; teamNumber < n; teamNumber++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < team[teamNumber].length; idx++) {
				team[teamNumber][idx] = Integer.parseInt(st.nextToken());
			}
		}

		// 몇 개의 팀이 조건을 만족했는지 검사
		for (int teamNumber = 0; teamNumber < n; teamNumber++) {
			check(team[teamNumber]);
		}
		sb.append(checkedTeam).append("\n");

		// 조건을 만족한 팀의 개인 점수 출력
		for (int teamNumber = 0; teamNumber < n; teamNumber++) {
			if (check(team[teamNumber])) { // 조건을 만족한다면
				for (int t : team[teamNumber]) {
					sb.append(t).append(" "); // 출력
				}
			}
		}

		System.out.println(sb);
	}

}
