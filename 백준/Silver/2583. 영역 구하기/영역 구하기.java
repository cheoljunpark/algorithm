import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 맵의 가로(row), 세로(column), 직사각형 개수(rectangleCnt)를 입력받는다
 * 2. row x column 크기의 boolean배열 맵(map)을 만든다
 * 3. 직사각형 개수 별로 rowIdxStart, colIdxStart, rowIdxEnd, colIdxEnd를 각각 입력받는다
 * 4. 맵의 (rowIdxStart, colIdxStart) ~ (rowIdxEnd, colIdxEnd)까지 1로 만든다
 * 5. 맵의 각 인덱스를 돌며 bfs탐색을 한다
 * 6. bfs탐색
 *
 */

public class Main {
	static int row, column; // 맵의 가로, 세로
	static int rectangleCnt; // 직사각형의 개수
	static int[][] map; // 맵
	static boolean[][] visited; // 방문여부
	static int areaCnt; // 영역의 개수
	static int area; // 영역의 넓이
	static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상,하,좌,우
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));; // 입력
	static StringTokenizer st; // 토큰화

	static class Pos { // 위치 클래스
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void bfs(Pos pos) { // bfs 탐색 메소드
		Queue<Pos> queue = new ArrayDeque<>();
		queue.offer(pos);

		while (!queue.isEmpty()) {
			Pos now = queue.poll();
			// 4방탐색
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
					area++;
					queue.offer(new Pos(nx, ny));
				}
			}

		}

	}

	public static void main(String[] args) throws IOException {
		// 가로(column), 세로(row), 직사각형 개수(rectangleCnt) 입력받기
		st = new StringTokenizer(br.readLine().trim());
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		rectangleCnt = Integer.parseInt(st.nextToken());

		// 맵 생성
		map = new int[row][column];

		// 방문여부(visited) 생성
		visited = new boolean[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				map[i][j] = 1;
			}
		}

		// 직사각형 개수 별로 각 직사각형의 위치 입력받아
		// map에서 직사각형 부분 1로 만들기
		for (int rectangle = 0; rectangle < rectangleCnt; rectangle++) {
			st = new StringTokenizer(br.readLine().trim());
			int colIdxStart = Integer.parseInt(st.nextToken());
			int rowIdxStart = Integer.parseInt(st.nextToken());
			int colIdxEnd = Integer.parseInt(st.nextToken());
			int rowIdxEnd = Integer.parseInt(st.nextToken());

			for (int i = rowIdxStart; i < rowIdxEnd; i++) {
				for (int j = colIdxStart; j < colIdxEnd; j++) {
					map[i][j] = 0;
				}
			}
		}

		// 각 영역의 넓이를 담을 우선순위 큐 만들기
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// 맵의 각 인덱스를 돌며 bfs 탐색
		for (int rowIdx = 0; rowIdx < row; rowIdx++) {
			for (int colIdx = 0; colIdx < column; colIdx++) {
				if (!visited[rowIdx][colIdx] && map[rowIdx][colIdx] == 1) {
					area = 1;
					visited[rowIdx][colIdx] = true;
					bfs(new Pos(rowIdx, colIdx));
					pq.offer(area);
					areaCnt++;
				}
			}

		}

		// 출력
		// 영역의 개수과
		// 각 영역의 넓이 오름차순 정렬해서 출력
		System.out.println(areaCnt);
		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
	}

}
