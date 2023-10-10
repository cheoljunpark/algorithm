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
 * 1. 맵의 가로(rowSize), 세로(colSize), 시간(time)을 입력받는다
 * 2. 맵을 생성한다
 * 3. 맵의 정보를 입력받는다
 *    3.1 값이 -1인 공기청정기 중 rowIdx가 더 작은 것을 airConditioner1
 *        rowIdx가 더 큰 것을 airConditioner2로 지정한다
 * 4. 매초마다 미세먼지 먼저 확산한 후, 공기청정기가 가동된다.
 * 5. time초가 모두 지난 후 미세먼지 양을 출력한다
 *
 */

public class Main {
	static int rowSize, colSize, time;
	static int[][] map;
	static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Point upside, downside;
	static final int PURIFIER = -1; // 공기청정기 상수 처리

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void spread() {
		int[][] dust = new int[rowSize][colSize]; // 추가 시킬 먼지를 담을 2차원 배열
		Queue<Point> queue = new ArrayDeque<>();

		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			for (int colIdx = 0; colIdx < colSize; colIdx++) {
				if (map[rowIdx][colIdx] > 0) { // 먼지 칸이면
					queue.offer(new Point(rowIdx, colIdx)); // 큐에 넣기
				}
			}
		}

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			int part = map[now.x][now.y] / 5;
			for (int[] dir : DIR) {
				int nx = now.x + dir[0];
				int ny = now.y + dir[1];
				if (nx < 0 || nx >= rowSize || ny < 0 || ny >= colSize || map[nx][ny] == PURIFIER) {
					continue;
				}
				dust[nx][ny] += part;
				map[now.x][now.y] -= part;
			}
		}
		
		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			for (int colIdx = 0; colIdx < colSize; colIdx++) {
				map[rowIdx][colIdx] += dust[rowIdx][colIdx];
			}
		}
	}
	
	static void purify() {
		purifyCounterClockwise();
		purifyClockwise();
	}

	static void purifyCounterClockwise() {
		for (int rowIdx = upside.x - 1; rowIdx > 0; rowIdx--) {
			map[rowIdx][0] = map[rowIdx - 1][0];
		}

		for (int colIdx = 0; colIdx < colSize - 1; colIdx++) {
			map[0][colIdx] = map[0][colIdx + 1];
		}

		for (int rowIdx = 0; rowIdx < upside.x; rowIdx++) {
			map[rowIdx][colSize - 1] = map[rowIdx + 1][colSize - 1];
		}

		for (int colIdx = colSize - 1; colIdx > 1; colIdx--) {
			map[upside.x][colIdx] = map[upside.x][colIdx - 1];
		}

		map[upside.x][1] = 0;
	}

	static void purifyClockwise() {
		for (int rowIdx = downside.x + 1; rowIdx < rowSize - 1; rowIdx++) {
			map[rowIdx][0] = map[rowIdx + 1][0];
		}

		for (int colIdx = 0; colIdx < colSize - 1; colIdx++) {
			map[rowSize - 1][colIdx] = map[rowSize - 1][colIdx + 1];
		}

		for (int rowIdx = rowSize - 1; rowIdx > downside.x; rowIdx--) {
			map[rowIdx][colSize - 1] = map[rowIdx - 1][colSize - 1];
		}

		for (int colIdx = colSize - 1; colIdx > 1; colIdx--) {
			map[downside.x][colIdx] = map[downside.x][colIdx - 1];
		}

		map[downside.x][1] = 0;
	}

	static int getRemainedDust() { // 남은 먼지 양 구하는 메소드
		int remainedDust = 0;

		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			for (int colIdx = 0; colIdx < colSize; colIdx++) {
				if (map[rowIdx][colIdx] != PURIFIER) { // 공기청정기 칸이 아니라면
					remainedDust += map[rowIdx][colIdx]; // 누적
				}
			}
		}

		return remainedDust;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 맵의 가로(rowSize), 세로(colSize), 시간(time)을 입력받는다
		st = new StringTokenizer(br.readLine().trim());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());

		// 맵 생성
		map = new int[rowSize][colSize];

		// 맵의 정보를 입력받는다
		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int colIdx = 0; colIdx < colSize; colIdx++) {
				map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				if (map[rowIdx][colIdx] == PURIFIER) { // 공기청정기라면
					if (upside == null) { // 위쪽 공기청정기가 아직 할당 안되었다면
						upside = new Point(rowIdx, colIdx); // 위쪽 공기청정기 할당
					} else if (upside != null && downside == null) { // 위쪽은 할당 되었고 아래쪽이 아직 할당 되지 않았다면
						downside = new Point(rowIdx, colIdx); // 아래쪽 공기청정기 할당
					}
				}
			}
		}

		// 각 초마다 먼지 확산 + 공기정화 
		for (int t = 0; t < time; t++) {
			spread(); // 먼지 확산
			purify(); // 공기 정화
		}

		// 남은 먼지 양 출력
		System.out.println(getRemainedDust());
	}

}
