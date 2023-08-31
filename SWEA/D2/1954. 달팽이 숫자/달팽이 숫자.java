import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스(testCase)를 입력받는다
 * 2. 각 테스트 케이스별로 맵 사이즈(mapSize)를 입력받는다
 * 3. mapSize x mapSize 크기의 맵(map)을 생성한다
 * 4. mapSize x mapSize 크기의 방문처리(visited)를 생성한다
 * 5. 맵의 좌표(0, 0)부터 순회를 시작한다
 *    5.1 순회하면서 이동 횟수(movedCount)를 맵에 저장한다 
 *    5.2 초기 순회 방향을 동쪽으로 순회한다
 *    5.3 동쪽으로가다가 경계값에 도달하면 방향을 남쪽으로 변경한다
 *    5.4 남쪽으로가다가 경계값에 도달하면 방향을 서쪽으로 변경한다
 *    5.5 서쪽으로가다가 경계값에 도달하면 방향을 북쪽으로 변경한다
 *    5.6 북쪽으로가다가 경계값에 도달하면 방향을 동쪽으로 변경한다
 * 6. (5.2 ~ 5.5)를 반복하면서 이동횟수가 mapsize*mapSize와 같아진다면 종료
 * 7. 맵을 출력
 *
 */

public class Solution {
	static int mapSize;
	static int[][] map;
	static boolean[][] visited;
	static final int[][] DIRECTION = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 동, 남, 서, 북
	static int[] currentDirection;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static class Pos { // 좌표 클래스
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void move() {
			this.x += currentDirection[0];
			this.y += currentDirection[1];
		}
	}

	static void checkBoundary(Pos pos) {	// 경계값 확인하는 메소드
		if (pos.x + currentDirection[0] == -1 || pos.x + currentDirection[0] == mapSize
				|| pos.y + currentDirection[1] == -1 || pos.y + currentDirection[1] == mapSize) { // 다음 값이 경계값이라면 방향 변경
			changeDirection();
		} else if (visited[pos.x + currentDirection[0]][pos.y + currentDirection[1]]) {	// 다음 값이 방문한적이 있는 곳이라면 방향 변경
			changeDirection();
		}
	}

	static void changeDirection() {	// 순회 방향 변경하는 메소드
		if (currentDirection[0] == DIRECTION[0][0] && currentDirection[1] == DIRECTION[0][1]) { // 동쪽 방향이였다면 남쪽 방향으로 변경
			currentDirection[0] = DIRECTION[1][0];
			currentDirection[1] = DIRECTION[1][1];
		} else if (currentDirection[0] == DIRECTION[1][0] && currentDirection[1] == DIRECTION[1][1]) { // 남쪽 방향이였다면 서쪽 방향으로 변경
			currentDirection[0] = DIRECTION[2][0];
			currentDirection[1] = DIRECTION[2][1];
		} else if (currentDirection[0] == DIRECTION[2][0] && currentDirection[1] == DIRECTION[2][1]) { // 서쪽 방향이였다면 북쪽 방향으로 변경
			currentDirection[0] = DIRECTION[3][0];
			currentDirection[1] = DIRECTION[3][1];
		} else { // 북쪽 방향이였다면 동쪽 방향으로 변경
			currentDirection[0] = DIRECTION[0][0];
			currentDirection[1] = DIRECTION[0][1];
		}
	}

	public static void main(String[] args) throws IOException {

		// 테스트 케이스 입력
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= testCase; tc++) {

			// 맵 사이즈 입력받기
			mapSize = Integer.parseInt(br.readLine().trim());

			// 맵 생성
			map = new int[mapSize][mapSize];

			// 방문처리 생성
			visited = new boolean[mapSize][mapSize];

			// 순회 시작할 좌표 값
			Pos pos = new Pos(0, 0);

			// 맵 순회하면서 값 저장
			int movedCount = 0; // 이동 횟수 초기화

			// 초기 방향(동쪽) 세팅
			currentDirection = new int[2];
			currentDirection[0] = DIRECTION[0][0];
			currentDirection[1] = DIRECTION[0][1];

			while (true) {
				if (movedCount == mapSize * mapSize) { // 종료 조건(맵에 값을 다 채웠다면 종료)
					break;
				}

				map[pos.x][pos.y] = ++movedCount; // 맵에 값을 저장하고
				visited[pos.x][pos.y] = true; // 방문처리하고
				checkBoundary(pos); // 이동하기 전에 경계값 체크해서 이동 방향 변경하고
				pos.move();// 좌표값 이동

			}

			// 맵 값 append
			sb.append("#").append(tc).append("\n");
			for (int rowIdx = 0; rowIdx < mapSize; rowIdx++) {
				for (int colIdx = 0; colIdx < mapSize; colIdx++) {
					sb.append(map[rowIdx][colIdx]).append(" ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

}
