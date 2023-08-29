import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스(testCase)를 입력받는다
 * 2. 각 테스트 케이스 별로 맵 크기(mapSize)를 입력받는다
 * 3. 맵의 중심 좌표를 구한다
 * 4. 맵(map)을 생성해 입력받는다
 * 5. 맵의 각 인덱스 좌표가 중심과의 거리가 맵 크기의 절반 이하라면 수익(sum)에 더한다
 *
 */

public class Solution {
	static int mapSize; // 맵 사이트
	static int[][] map; // 맵
	static int mapRadius; // 맵 반지름
	static int sum; // 수익
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static class Pos { // 좌표 클래스
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int distance(Pos coordinate, Pos center) { // 거리 구하는 메소드
		return Math.abs(coordinate.x - center.x)+ Math.abs(coordinate.y - center.y);
	}

	public static void main(String[] args) throws IOException {

		// 테스트 케이스 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= testCase; tc++) { // 각 테스트 케이스 별로

			// 맵사이즈 입력받기
			mapSize = Integer.parseInt(br.readLine().trim());

			// 맵 생성
			map = new int[mapSize][mapSize];

			// 중심 좌표 구하기
			Pos center = new Pos(mapSize / 2, mapSize / 2);

			// 맵의 반지름
			mapRadius = mapSize / 2;

			// 수익 초기화
			sum = 0;

			// 맵 입력받으면서
			// 중심과의 거리 계산해서
			// 맵 반지름 이하라면
			// 수익에 더하기
			for (int rowIdx = 0; rowIdx < mapSize; rowIdx++) {
				String[] str = br.readLine().trim().split("");
				for (int colIdx = 0; colIdx < mapSize; colIdx++) {
					map[rowIdx][colIdx] = Integer.parseInt(str[colIdx]);
					Pos coordinate = new Pos(rowIdx, colIdx); // 현재 좌표 구해서
					if (distance(coordinate, center) <= mapRadius) { // 중심과의 거리가 맵 반지름 이하라면
						sum += map[rowIdx][colIdx]; // 수익에 더하기
					}
				}
			}

			// 출력
			System.out.println("#" + tc + " " + sum);
		}
	}
}
