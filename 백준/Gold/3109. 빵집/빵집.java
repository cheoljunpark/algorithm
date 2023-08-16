import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 맵의 행(row) 열(column)을 입력받는다
 * 2. row x column 크기의 맵을 만든다
 * 3. 맵의 빈칸('.')과 건물('.')을 입력받는다
 * 4. 첫번째 열의 0행 ~ row-1행까지 check() 메소드를 재귀 호출
 * 5. check() 메소드
 *    5.1 만약 열 번호가 c-1이라면(마지막 열까지 갔다면) true 리턴
 *    5.2 오른쪽 위 대각선 위치가 맵의 빈칸('.') 이라면 여기서 다시 check()
 *    5.3 오른쪽 위치가 맵의 빈칸('.') 이라면 여기서 다시 check()
 *    5.3 오른쪽 아래 위치가 맵의 빈칸('.') 이라면 여기서 다시 check()
 *    5.4 모두 아니라면 false 리턴 
 *
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String[][] map;
	static int row, column;
	static int cnt;

	public static boolean check(int rowIdx, int colIdx) {
		map[rowIdx][colIdx] = "-"; // 방문표시

		if (colIdx == column - 1) { // 마지막 열까지 갔다면
			return true;
		}

		if (rowIdx > 0 && map[rowIdx - 1][colIdx + 1].equals(".")) { // 오른쪽 위
			if (check(rowIdx - 1, colIdx + 1))
				return true;
		}

		if (map[rowIdx][colIdx + 1].equals(".")) { // 오른쪽
			if (check(rowIdx, colIdx + 1))
				return true;
		}

		if (rowIdx + 1 < row && map[rowIdx + 1][colIdx + 1].equals(".")) { // 오른쪽 아래
			if (check(rowIdx + 1, colIdx + 1))
				return true;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		// row, column 입력받기
		st = new StringTokenizer(br.readLine().trim());
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());

		// row x column 크기의 맵 만들기
		map = new String[row][column];

		// 맵 입력받기
		for (int rowIdx = 0; rowIdx < row; rowIdx++) {
			String[] str = br.readLine().trim().split("");
			for (int colIdx = 0; colIdx < column; colIdx++) {
				map[rowIdx][colIdx] = str[colIdx];
			}
		}

		// 첫번째 열의 0행 ~ row-1행까지 check() 메소드를 재귀 호출
		for (int rowIdx = 0; rowIdx < row; rowIdx++) {
			if (check(rowIdx, 0)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}
