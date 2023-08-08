import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력 받는다
 * 2. 각 테스트 케이스 별로 n과 k를 입력받는다
 * 3. 퍼즐 모양을 입력받는다
 * 4. 퍼즐의 각 행(가로), 각 열(세로)를 돌면서 길이가 k인 개수를 구한다
 *
 */

public class Solution {

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테스트 케이스 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			// n과 k 입력받기
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			// n X n 크기의 맵 선언
			int[][] map = new int[n][n];

			// 맵 정보 입력 받기
			for (int rowIdx = 0; rowIdx < n; rowIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int colIdx = 0; colIdx < n; colIdx++) {
					map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				}
			}

			// 길이 k가 들어갈 수 있는 곳의 개수
			int countK = 0;

			// 맵의 각 가로를 탐색해서 길이가 k인것을 카운트
			for (int rowIdx = 0; rowIdx < n; rowIdx++) {
				int tmpCnt = 0;
				for (int colIdx = 0; colIdx < n; colIdx++) {
					if (map[rowIdx][colIdx] == 1) { // 위치가 1이라면
						tmpCnt++;
					}
					if (map[rowIdx][colIdx] == 0 || colIdx == n - 1) {
						if (tmpCnt == k) {
							countK++;
						}
						if (map[rowIdx][colIdx] == 0)
							tmpCnt = 0;
					}
				}
			}

			// 맵의 각 세로를 탐색해서 길이가 k인것을 카운트
			for (int rowIdx = 0; rowIdx < n; rowIdx++) {
				int tmpCnt = 0;
				for (int colIdx = 0; colIdx < n; colIdx++) {
					if (map[colIdx][rowIdx] == 1) { // 위치가 1이라면
						tmpCnt++;
					}
					if (map[colIdx][rowIdx] == 0 || colIdx == n - 1) {
						if (tmpCnt == k) {
							countK++;
						}
						if (map[colIdx][rowIdx] == 0)
							tmpCnt = 0;
					}
				}
			}
			sb.append("#").append(tc + 1).append(" ").append(countK).append("\n");
		}

		System.out.println(sb);
	}

}
