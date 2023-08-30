import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 10개의 각 테스트 케이스(testCase)별로,
 * 2. 크기 100x100 맵(map) 배열 생성하고
 * 3. 맵을 입력받는다
 * 4. 첫 행의 각 열을 돌면서 값이 1면 사다리를 타고, 0이면 continue
 *    4.1 양 옆의 열에 체크하다가 해당하는 값이 둘 다 0이면 내려간다
 *    4.2 양 옆의 열을 체크하다가 해당하는 값 중에 하나가 1이면 그 방향으로 방향을 바꿔서 이동
 * 5. 사다리를 타다가 값이 2를 발견하면 해당 열 출력
 *
 */

public class Solution {
	static final int TEST_CASE = 10; // 테스트 케이스 개수
	static final int MAP_SIZE = 100; // 맵 사이즈
	static int[][] map; // 맵
	static int[] direction = { 1, 0 }; // 사다리를 이동 방향 -> 초기값: 남쪽 방향
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringBuilder sb = new StringBuilder(); // 출력
	static StringTokenizer st; // 토큰화

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void move() {
			this.x += direction[0];
			this.y += direction[1];
		}
	}

	static void checkHorizontal(Pos pos) { // 가로선이 있어서 방향을 바꿔야하는지 체크하는 메소드

		if (pos.y - 1 >= 0 && map[pos.x][pos.y - 1] == 1) { // 왼쪽에 가로선이 있다면 방향을 왼쪽으로 바꾸기
			direction[0] = 0;
			direction[1] = -1;
		} else if (pos.y + 1 < MAP_SIZE && map[pos.x][pos.y + 1] == 1) { // 오른쪽에 가로선이 있다면 방향을 오른쪽으로 바꾸기
			direction[0] = 0;
			direction[1] = 1;
		}

	}

	static void checkVertical(Pos pos) { // 세로선이 있어서 방향을 바꿔야하는지 체크하는 메소드
		if (pos.y == 0 || pos.y == MAP_SIZE - 1) {
			direction[0] = 1;
			direction[1] = 0;
			return;
		}

		if (direction[0] == 0 && direction[1] == -1 && map[pos.x][pos.y - 1] == 0) {
			direction[0] = 1;
			direction[1] = 0;
		} else if (direction[0] == 0 && direction[1] == 1 && map[pos.x][pos.y + 1] == 0) {
			direction[0] = 1;
			direction[1] = 0;
		}

	}

	public static void main(String[] args) throws IOException {

		// 10개의 테스트 케이스 별로
		for (int tc = 1; tc <= TEST_CASE; tc++) {

			// 테스트 케이스의 번호 입력받기
			// 그냥 날리면 되는듯 ..
			int testCase = Integer.parseInt(br.readLine().trim());

			// 맵 생성
			map = new int[MAP_SIZE][MAP_SIZE];

			// 맵 입력받기
			for (int rowIdx = 0; rowIdx < MAP_SIZE; rowIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int colIdx = 0; colIdx < MAP_SIZE; colIdx++) {
					map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				}
			}

			// 첫번째 행의 각 열에서 사다리 타기
			for (int colIdx = 0; colIdx < MAP_SIZE; colIdx++) {
				if (map[0][colIdx] == 0) { // 만약 사다리가 아니라면(값이 0이라면)
					continue;
				} else { // 만약 사다리라면(값이 1이라면)
					Pos pos = new Pos(0, colIdx); // 사다리의 시작점의 위치를 저장해서

					while (pos.x != MAP_SIZE - 1) { // 맵의 끝까지 사다리를 타고 내려가기
						if (direction[0] == 1 && direction[1] == 0) { // 남쪽 방향으로 이동하고 있을 때
							checkHorizontal(pos); // 이동중에 가로선이 있는지 체크, 있다면 방향 바꿈
						} else {
							checkVertical(pos);
						}
						pos.move(); // 향하는 방향으로 한칸 이동
					}

					if (map[pos.x][pos.y] == 2) { // 사다리 끝까지 이동했는데 당첨되면 해당 열 출력
						sb.append("#").append(tc).append(" ").append(colIdx).append("\n");
						break;
					}
				}
			}
		}

		System.out.println(sb);
	}

}
