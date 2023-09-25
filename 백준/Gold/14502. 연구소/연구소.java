import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.IntPredicate;

/**
 * 
 * @author 박철준
 * 
 * 1. 맵의 가로(rowSize)와 세로(colSize)를 입력받는다
 * 2. rowSize x colSize 크기의 맵을 생성한다
 * 3. 맵을 입력받는다
 * 4. 맵을 순회 하면서 빈칸(0)인 자리에 3개의 벽(1)을 세운다.
 * 5. 바이러스(2)가 퍼진다
 * 6. 바이러스가 모두 퍼진 뒤 빈칸의 개수를 구한다
 * 7. 빈칸의 개수가 최대인 것을 구해서 출력한다
 *
 */

public class Main {
	static int rowSize, colSize;
	static int[][] originalMap;
	static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static int maxSafeZone = Integer.MIN_VALUE; // 최댓값을 찾기 위한 최솟값 설정
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void dfs(int wallCnt) {
		// 벽이 3개가 설치 되었을 때 bfs 탐색
		if (wallCnt == 3) {
			bfs();
			return;
		}

		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			for (int colIdx = 0; colIdx < colSize; colIdx++) {
				if (originalMap[rowIdx][colIdx] == 0) {
					originalMap[rowIdx][colIdx] = 1;
					dfs(wallCnt + 1);
					originalMap[rowIdx][colIdx] = 0;
				}
			}
		}
	}

	static void bfs() {
		Queue<Node> queue = new LinkedList<>();

		// 바이러스의 위치를 큐에 저장
		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			for (int colIdx = 0; colIdx < colSize; colIdx++) {
				if (originalMap[rowIdx][colIdx] == 2) {
					queue.add(new Node(rowIdx, colIdx));
				}
			}
		}

		// 원본 맵 말고 카피맵 사용
		int[][] copyMap = new int[rowSize][colSize];

		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			copyMap[rowIdx] = originalMap[rowIdx].clone();
		}

		// bfs 탐색
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			int x = now.x;
			int y = now.y;

			for (int[] dir : DIR) {
				int nx = x + dir[0];
				int ny = y + dir[1];

				// 조건 범위일때 바이러스 퍼트리기
				if ((nx >= 0 && nx < rowSize) && (ny >= 0 && ny < colSize)) {
					if (copyMap[nx][ny] == 0) {
						queue.add(new Node(nx, ny));
						copyMap[nx][ny] = 2;
					}
				}
			}
		}

		// SafeZone 확인
		checkSafeZone(copyMap);
	}

	static void checkSafeZone(int[][] copyMap) {
		int safeZone = 0;
		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			for (int colIdx = 0; colIdx < colSize; colIdx++) {
				if (copyMap[rowIdx][colIdx] == 0) {
					safeZone++;
				}
			}
		}

		if (maxSafeZone < safeZone) {
			maxSafeZone = safeZone;
		}
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		// 맵의 가로 세로 입력
		st = new StringTokenizer(br.readLine().trim());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		// 맵 생성
		originalMap = new int[rowSize][colSize];

		// 맵 입력받기
		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int colIdx = 0; colIdx < colSize; colIdx++) {
				originalMap[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(maxSafeZone);
	}

}
