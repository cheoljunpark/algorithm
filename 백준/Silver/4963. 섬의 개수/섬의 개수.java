import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 맵의 width와 height를 입력받는데, 둘 다 0이 아닌동안 계속 입력받는다
 * 2. width x height 크기의 맵(map)을 입력받는다
 * 3. 맵의 각 인덱스에서 bfs탐색을 해서 섬의 개수를 구한다
 *
 */

public class Main {
	static int row, column; // 맵의 너비, 높이
	static int[][] map; // 맵
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringTokenizer st; // 토큰화
	static int islandCnt; // 섬의 개수
	static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 }, { 1, 1 } }; // 상,하,좌,우,좌상,좌하,우상,우하
	static boolean[][] visited; // 방문

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs(Pos pos) {

		// 그 방향으로 탐색
		Queue<Pos> queue = new ArrayDeque<>();
		queue.offer(pos);

		while (!queue.isEmpty()) {
			Pos now = queue.poll();
			for (int[] dir : DIR) {
				int nx = now.x + dir[0];
				int ny = now.y + dir[1];
				if (nx < 0 || nx >= row || ny < 0 || ny >= column) {
					continue;
				}
				if (visited[nx][ny]) {
					continue;
				}
				if (map[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.offer(new Pos(nx, ny));
				}
			}

		}
//		islandCnt++;
		
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			// width와 height 입력받기
			st = new StringTokenizer(br.readLine().trim());
			column = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());

			// width와 height가 0이면 종료
			if (row == 0 && column == 0) {
				break;
			}

			// 맵 생성
			map = new int[row][column];

			// 방문체크(visited) 배열 생성
			visited = new boolean[row][column];

			// 맵 입력받기
			for (int rowIdx = 0; rowIdx < row; rowIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int colIdx = 0; colIdx < column; colIdx++) {
					map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				}
			}

			// bfs 탐색
			islandCnt = 0;
			for (int rowIdx = 0; rowIdx < row; rowIdx++) {
				for (int colIdx = 0; colIdx < column; colIdx++) {
					if (!visited[rowIdx][colIdx]&&map[rowIdx][colIdx]==1) {
						visited[rowIdx][colIdx] = true;
						bfs(new Pos(rowIdx, colIdx));
						islandCnt++;

					}
				}
			}

			System.out.println(islandCnt);
		}
	}

}
