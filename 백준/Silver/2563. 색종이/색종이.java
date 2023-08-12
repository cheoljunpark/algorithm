import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2차 풀이
 * 
 * @author 박철준
 * 1. 색종이의 수(n)을 입력받는다
 * 2. 100 x 100 크기의 boolean 배열(map)을 만든다
 * 3. n개의 색종이의 좌측하단 위치를 입력받는다
 * 4. 각 좌측하단 위치부터 가로 10, 세로 10 크기만큼
 *    map의 인덱스를 true로 만든다.
 * 5. 색종이가 붙은 영역의 넓이를 출력하기 위해
 *    map의 각 인덱스를 돌면서 true인 부분의 개수를 구한다 
 *
 */

public class Main {

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 색종이 개수 입력받기
		int n = Integer.parseInt(br.readLine().trim());

		// 100 x 100 크기 boolean 배열(map) 만들기
		boolean[][] map = new boolean[100][100];

		for (int i = 0; i < n; i++) { // 색종이 수 만큼
			// 색종이의 좌측하단 위치 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken()); // 색종이의 좌측하단 x좌표
			int y = Integer.parseInt(st.nextToken()); // 색종이의 좌측하단 y좌표

			// 좌측하단 위치부터 가로10, 세로 10 만큼
			// map의 인덱스 true로 만들기
			for (int rowIdx = x; rowIdx < x + 10; rowIdx++) {
				for (int colIdx = y; colIdx < y + 10; colIdx++) {
					map[rowIdx][colIdx] = true;
				}
			}

		}

		// map의 각 인덱스를 돌면서 true의 개수 구하기
		int cnt = 0;
		for (int rowIdx = 0; rowIdx < map.length; rowIdx++) {
			for (int colIdx = 0; colIdx < map[rowIdx].length; colIdx++) {
				if (map[rowIdx][colIdx] == true) {
					cnt++;
				}
			}
		}

		// 출력
		sb.append(cnt).append("\n");
		System.out.println(sb);
	}

}
