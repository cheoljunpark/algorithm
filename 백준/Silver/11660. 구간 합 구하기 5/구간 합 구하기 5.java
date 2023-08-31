import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 맵 사이트(mapSize)와 연산 횟수(operatorCount)를 입력받는다
 * 2. (mapSize+1) x (mapSize+1) 크기의 맵(map)을 생성한다
 * 3. 맵을 입력받는다
 * 4. 입력 받을 때 각 행의 각각의 열의 값은, 각 행의 누적 값을 저장한다
 * 5. 연산 횟수만큼  연산을 수행해야하는 좌표(startX, startY, endX, endY) 를 입력받는다
 * 6. 맵의 시작 좌표부터 끝 좌표까지의 합을 구해서 출력한다
 *    -> map[startX][endY] - map[startX][endY-1] 
 *
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int mapSize;
	static int operationCount;
	static int[][] map;
	static int startX, startY, endX, endY;

	public static void main(String[] args) throws IOException {

		// 맵 사이트(mapSize)와 연산 횟수(operatorCount)를 입력받기
		st = new StringTokenizer(br.readLine().trim());
		mapSize = Integer.parseInt(st.nextToken());
		operationCount = Integer.parseInt(st.nextToken());

		// 맵 생성
		map = new int[mapSize + 1][mapSize + 1];

		// 맵 입력받으면서 누적합 저장
		for (int rowIdx = 1; rowIdx <= mapSize; rowIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int colIdx = 1; colIdx <= mapSize; colIdx++) {
				map[rowIdx][colIdx] = map[rowIdx][colIdx - 1] + Integer.parseInt(st.nextToken());
			}
		}

		for (int operation = 0; operation < operationCount; operation++) {
			// 연산을 수행해야하는 시작 좌표(coordinateStart), 끝 좌표(coordinateEnd)를 입력받기
			st = new StringTokenizer(br.readLine().trim());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());

			// 맵의 시작 좌표부터 끝 좌표까지의 합을 구해서 append
			// -> 각 행의 map[startX1][endY2] - map[startX1][endY1-1]
			// 누적합 append
			int cumulativeSum = 0;
			for (int rowIdx = startX; rowIdx <= endX; rowIdx++) {
				cumulativeSum += map[rowIdx][endY] - map[rowIdx][startY - 1];
			}
			sb.append(cumulativeSum).append("\n");
		}

		// 출력
		System.out.println(sb);
	}

}
