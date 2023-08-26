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
 * 1. 행(row)과 열(column)을 입력받는다
 * 2. row x column 크기의 맵(map)을 생성한다
 * 3. 맵을 입력받는다
 * 4. (0, 0) 인덱스에서 bfs탐색을 해서 (row-1, column-1) 인덱스 까지의 최소값을 구한다
 *
 */

public class Main {
	static int row, column; // 행과 열
	static int[][] map; // 맵
	static boolean[][] visited; // 방문여부
	static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static int movedCnt; // 이동한 칸 수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringTokenizer st; // 토큰화

	// 위치 클래스
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	// bfs
	static void bfs(Pos pos) {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(pos);

		while (!q.isEmpty()) {
			Pos now = q.poll();
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
					map[nx][ny] = map[now.x][now.y] + 1;	// 이동하면서 이전 칸의 값보다 1 큰 정수 저장
					q.offer(new Pos(nx, ny));
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// 행과 열 입력받기
		st = new StringTokenizer(br.readLine().trim());
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());

		// 맵 생성
		map = new int[row][column];

		// visited 생성
		visited = new boolean[row][column];

		// 맵 입력받기
		for (int rowIdx = 0; rowIdx < row; rowIdx++) {
			String[] s = br.readLine().trim().split("");
			for (int colIdx = 0; colIdx < column; colIdx++) {
				map[rowIdx][colIdx] = Integer.parseInt(s[colIdx]);
			}
		}

		// (0,0)에서 bfs 탐색
		bfs(new Pos(0, 0));

		// 움직여야 하는 최소 칸 수 출력
		System.out.println(map[row - 1][column - 1]);
	}

}
