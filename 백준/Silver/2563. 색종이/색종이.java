import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 색종이 수(n)을 입력받는다
 * 2. 각 색종이 마다 위치를 입력받는다
 * 3. 100 x 100 크기의 int 배열(map)을 선언하고
 * 4. 각 색종이 위치에서 가로, 세로 크기 10만큼 map의 각 인덱스에 해당하는 값들을 1로 바꾼다
 * 5. map에서 값 1의 개수를 구해서 출력
 *
 */

public class Main {

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 색종이 수 (n) 입력받기
		int n = Integer.parseInt(br.readLine().trim());

		// 100 x 100 크기의 map 선언
		int[][] map = new int[100][100];

		for (int i = 0; i < n; i++) { // 각 색종이 마다 위치 입력 받기
			st = new StringTokenizer(br.readLine().trim());

			// 좌표 x, y 값 입력받기
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 좌표 (x, y)에서 가로, 세로 크기 10만큼
			// map의 각 인덱스에 해당하는 값들을 1로 바꾸기
			for (int rowIdx = 0; rowIdx < 10; rowIdx++) {
				for (int colIdx = 0; colIdx < 10; colIdx++) {
					map[x + rowIdx][y + colIdx] = 1;
				}
			}
		}

		// map에서 값 1의 개수를 구해서 출력
		int area = 0;
		for (int rowIdx = 0; rowIdx < 100; rowIdx++) {
			for (int colIdx = 0; colIdx < 100; colIdx++) {
				if (map[rowIdx][colIdx] == 1) {
					area++;
				}
			}
		}

		sb.append(area).append("\n");
		System.out.println(sb);
	}

}
