import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 박철준
 * 
 * 1. 9 x 9 크기의 맵을 생성한다
 * 2. 맵을 입력받는다
 * 3. 백트래킹을 이용해 0이 있는 위치에 숫자를 입력한다
 * 4. 맵에 0이 없다면 백트래킹을 종료한다
 * 5. 맵을 출력
 *
 */

public class Main {

	static int[][] map = new int[9][9];
	static final int MAP_SIZE = 9;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static boolean ok;
	
	
	
	static void Sudoku(int rowIdx, int colIdx) {
		if(ok) {
			return;
		}
		
		
		// 기저 조건
		// 맵에 0이 없을 때 까지
		if (rowIdx == 9 && colIdx == 0) {
//			if (!isZeroExist()) {
				// 스도쿠 append
				for (int row = 0; row < MAP_SIZE; row++) {
					for (int col = 0; col < MAP_SIZE; col++) {
						sb.append(map[row][col]);
					}
					sb.append("\n");
				}
//				return;
//			}
			System.out.println(sb);
			ok = true;
			return;
		}

		// 진행 로직
		if (map[rowIdx][colIdx] == 0) {
			for (int number = 1; number <= 9; number++) {
				if (isPossible(rowIdx, colIdx, number)) {
					map[rowIdx][colIdx] = number;

					if (colIdx == 8) {
						Sudoku(rowIdx + 1, 0);
					} else {
						Sudoku(rowIdx, colIdx + 1);
					}

					map[rowIdx][colIdx] = 0;
				}
			}
		} else {
			if (colIdx == 8) {
				Sudoku(rowIdx + 1, 0);
			} else {
				Sudoku(rowIdx, colIdx + 1);
			}
		}

	}

	static boolean isZeroExist() { // 맵에 0이 있는지 확인하는 메소드
		for (int rowIdx = 0; rowIdx < MAP_SIZE; rowIdx++) {
			for (int colIdx = 0; colIdx < MAP_SIZE; colIdx++) {
				if (map[rowIdx][colIdx] == 0) {
					return true; // 0이 있다면(스도쿠 완료 X)
				}
			}
		}
		return false; // 0이 없다면(스도쿠 완료)
	}

	static boolean isPossible(int rowIdx, int colIdx, int number) {

		// 가로, 세로 체크
		for (int idx = 0; idx < MAP_SIZE; idx++) {
			if (map[rowIdx][idx] == number || map[idx][colIdx] == number) {
				return false;
			}
		}

		// 블록 체크
		int blockStartRow = (rowIdx / 3) * 3;
		int blockStartCol = (colIdx / 3) * 3;

		for (int i = blockStartRow; i < blockStartRow + 3; i++) {
			for (int j = blockStartCol; j < blockStartCol + 3; j++) {
				if (map[i][j] == number) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		// 맵 입력받기
		for (int rowIdx = 0; rowIdx < MAP_SIZE; rowIdx++) {
			String input = br.readLine().trim();
			for (int colIdx = 0; colIdx < MAP_SIZE; colIdx++) {
				map[rowIdx][colIdx] = input.charAt(colIdx) - '0';
			}
		}

		// 스도쿠 시작
		Sudoku(0, 0);

		// 스도쿠 출력
//		System.out.println(sb);
	}

}
