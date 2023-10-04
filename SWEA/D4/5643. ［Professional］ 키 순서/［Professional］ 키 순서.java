import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스(testCase)를 입력받는다
 * 2. 각 테스트 케이스별로 학생 수(studentCount)를 입력받는다
 * 3. 비교 횟수(compareCount)를 입력받는다
 * 4. 비교 횟수 만큼 정보를 입력받아 인접 행렬에 저장한다
 * 5. 인접행렬에서 자기보다 작은 애와 큰 애의 수를 구한다
 * 6. 자기보다 작은 애 + 큰 애 = 전체 학생수 - 1(자기자신)이 되면
 *    자신이 몇 번째인지 알 수 있는 학생이다
 */

public class Solution {
	static int testCase, studentCount, compareCount;
	static int[][] map;
	static int smallerCount, tallerCount;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static void taller(int from, boolean[] visited) { // 인접행렬에서 자기보다 더 큰 애 찾는 메소드
		visited[from] = true;
		for (int count = 1; count <= studentCount; count++) {
			if (!visited[count] && map[from][count] == 1) {
				taller(count, visited);
				tallerCount++;
			}
		}
	}

	static void smaller(int to, boolean[] visited) { // 인접행렬에서 자기보다 더 작은 애 찾는 메소드
		visited[to] = true;
		for (int count = 1; count <= studentCount; count++) {
			if (!visited[count] && map[count][to] == 1) {
				smaller(count, visited);
				smallerCount++;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		// 테스트 케이스 입력
		testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= testCase; tc++) { // 각 테스트 케이스 별로

			// 학생 수 입력
			studentCount = Integer.parseInt(br.readLine().trim());

			// 비교 횟수 입력
			compareCount = Integer.parseInt(br.readLine().trim());

			// 인접행렬 생성
			map = new int[studentCount + 1][studentCount + 1];

			// 키 정보 입력받아 인접 행렬에 정보 저장
			for (int count = 0; count < compareCount; count++) {
				st = new StringTokenizer(br.readLine().trim());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = 1;
			}

			// 키가 몇 번째 인지 알 수 있는 학생 수 초기화
			int answer = 0;

			// 키가 몇 번째 인지 알 수 있는 학생 수 구하기
			// 자신보다 작은 애(smallerCount) + 자신보다 큰 애(tallerCount) = 전체 학생수 - 1이면 됨
			for (int count = 1; count <= studentCount; count++) {
				smallerCount = 0;
				tallerCount = 0;
				taller(count, new boolean[studentCount + 1]); // 자신보다 작은 애 구하기
				smaller(count, new boolean[studentCount + 1]); // 자신보다 큰 애 구하기
				if (smallerCount + tallerCount == studentCount - 1) {
					answer++;
				}
			}

			// 정답 append
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		// 정답 출력
		System.out.println(sb);
	}

}
