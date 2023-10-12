import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 맵의 가로, 세로를 입력받는다
 * 2. 맵을 생성하고 정보를 입력받는다
 * 3. 맵의 각 인덱스에서(상어 칸이라면 패스) bfs 탐색을 해 상어와의 최솟값을 구해서 리스트에 넣는다
 * 4. 리스트의 최댓값을 구한다
 *
 */

public class Main {
	static int rowSize, colSize;
	static int[][] map;
	static boolean[][] visited;
	static int[][] safe;
	static final int SHARK = 1;
	static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
	static ArrayList<Integer> distance = new ArrayList<>();

	static class Pos {
		int x, y, distance;

		public Pos(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}

	static void bfs(Pos pos) {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(pos);
		visited = new boolean[rowSize][colSize];
		visited[pos.x][pos.y] = true;
		
		while (!q.isEmpty()) {
			Pos now = q.poll();

			if(map[now.x][now.y]==SHARK) {
				safe[pos.x][pos.y]  = Math.min(safe[pos.x][pos.y], now.distance);
				continue;
			}
			
			for (int[] dir : DIR) {
				int nx = now.x + dir[0];
				int ny = now.y + dir[1];

				if (isPossible(nx, ny)) {
					visited[nx][ny] = true;
					q.offer(new Pos(nx, ny, now.distance+1));
				}
				
			}
		}
	}

	static boolean isPossible(int nx, int ny) {
		return 0 <= nx && nx < rowSize && 0 <= ny && ny < colSize && !visited[nx][ny];
	}

	public static void main(String[] args) throws IOException {
		// 맵의 가로, 세로를 입력받는다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		// 맵 생성
		map = new int[rowSize][colSize];
		
		// 안전 거리 저장할 배열
		safe = new int[rowSize][colSize];
		
		// 안전 거리 세팅
		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			for (int colIdx = 0; colIdx < colSize; colIdx++) {
				safe[rowIdx][colIdx] = Integer.MAX_VALUE;
			}
		}

		// 맵 입력받기
		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int colIdx = 0; colIdx < colSize; colIdx++) {
				map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
			}
		}

		// 각 인덱스에서 bfs 탐색
		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			for (int colIdx = 0; colIdx < colSize; colIdx++) {
				if (map[rowIdx][colIdx] != SHARK) {
					bfs(new Pos(rowIdx, colIdx, 0));
				}
			}
		}
		
//		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
//			for (int colIdx = 0; colIdx < colSize; colIdx++) {
//				System.out.print(safe[rowIdx][colIdx]+" ");
//			}
//			System.out.println();
//		}
//		
		
		// safe 배열에서 최댓값 찾기
		int minSafe = Integer.MIN_VALUE;
		for (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
			for (int colIdx = 0; colIdx < colSize; colIdx++) {
				if(map[rowIdx][colIdx] != SHARK) {
					minSafe = Math.max(minSafe, safe[rowIdx][colIdx]);
				}
			}
		}
		
		// 출력
		System.out.println(minSafe);
	}

}
