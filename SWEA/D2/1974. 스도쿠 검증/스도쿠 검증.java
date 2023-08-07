import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스 별로 9x9 크기의 퍼즐을 입력받는다
 * 3. 가로줄, 세로줄, 3x3사각형의 1부터 9까지 있는지 여부를 판단하는 배열을 만든다
 * 4. 가로줄, 세로줄, 3x3사각형을 판단한다
 *    4.1 가로줄은 각 행의 모든 열을 판단
 *    4.2 세로줄은 각 열의 모든 행을 판단
 *    4.3 3x3은 행, 열을 3씩 증가하면서 3x3씩 판단
 * 5. 4번을 시행하면서 1~9까지 없는 배열이 나타나면 flag를 0으로 만들기 
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

		// 각 테스트 케이스 별로
		for (int tc = 0; tc < testCase; tc++) {
			// 9x9 퍼즐 선언
			int[][] map = new int[9][9];

			// 9x9 퍼즐 입력받기
			for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int colIdx = 0; colIdx < 9; colIdx++) {
					map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				}
			}

			// flag 변수(겹치는 숫자가 없으면 1, 있으면 0)
			int flag = 1;

			// 가로줄 판단
			for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
				// 각 가로줄마다 1~9 존재여부 판단 배열
				boolean[] rowFlag = new boolean[9];

				// 각 열을 돌면서 숫자들을 순회해서 존재하는 것들을 true로 바꾸기
				for (int colIdx = 0; colIdx < 9; colIdx++) {
					rowFlag[map[rowIdx][colIdx] - 1] = true;
				}

				// rowFlag에 모든 숫자가 있는지 판단
				for (int i = 0; i < 9; i++) {
					if (rowFlag[i] == false)
						flag = 0;
				}
			}

			// 세로줄 판단
			for (int colIdx = 0; colIdx < 9; colIdx++) {
				// 각 세로줄마다 1~9 존재여부 판단 배열
				boolean[] colFlag = new boolean[9];

				// 각 행을 돌면서 숫자들을 순회해서 존재하는 것들을 true로 바꾸기
				for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
					colFlag[map[rowIdx][colIdx] - 1] = true;
				}

				// colFlag에 모든 숫자가 있는지 판단
				for (int i = 0; i < 9; i++) {
					if (colFlag[i] == false)
						flag = 0;
				}
			}

			// 3x3 판단
			for (int rowIdx = 0; rowIdx < 9; rowIdx += 3) {
				// 각 3x3마다 1~9 존재여부 판단 배열
				boolean[] threeByThreeFlag = new boolean[9];

				// 각 3x3의 첫 번째 숫자에서부터 순회해 존재하는 것들을 true로 바꾸기
				for (int colIdx = 0; colIdx < 9; colIdx += 3) {

					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							threeByThreeFlag[map[rowIdx + i][colIdx + j] - 1] = true;
						}
					}

					// threeByThreeFlag에 모든 숫자가 있는지 판단
					for (int i = 0; i < 9; i++) {
						if (threeByThreeFlag[i] == false)
							flag = 0;
					}
				}

			}

			sb.append("#").append(tc + 1).append(" ").append(flag).append("\n");
		}

		System.out.println(sb);
	}

}
