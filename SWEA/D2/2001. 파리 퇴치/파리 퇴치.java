import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스(testCase)를 입력받는다
 * 2. 각 테스트 케이스별로 맵의 크기(mapSize)와 파워(power)를 입력받는다
 * 3. mapSize x mapSize 크기의 맵(map)을 생성하고
 * 4. 맵을 입력받는다
 * 5. 맵의 각 인덱스를 돌면서 동남쪽 방향으로 power 크기만큼 탐색해 최대값을 구한다
 *
 */

public class Solution {
	static int[][] map;
	static int mapSize;
	static int power;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int findSum(int rowIdx, int colIdx) { // 맵에서 power x power 크기 안에 있는 수를 모두 합하는 메소드
		int sum = 0;

		for (int r = rowIdx; r < rowIdx + power; r++) {
			for (int c = colIdx; c < colIdx + power; c++) {
				if (r >= mapSize || c >= mapSize) { // 경계를 벗어나면 패스
					continue;
				}
				sum += map[r][c];
			}
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {

		// 테스트 케이스 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= testCase; tc++) {
			// 맵 사이즈와 파워 입력받기
			st = new StringTokenizer(br.readLine().trim());
			mapSize = Integer.parseInt(st.nextToken());
			power = Integer.parseInt(st.nextToken());

			// 맵 생성
			map = new int[mapSize][mapSize];

			// 맵 입력받기
			for (int rowIdx = 0; rowIdx < mapSize; rowIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int colIdx = 0; colIdx < mapSize; colIdx++) {
					map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				}
			}

			// 맵의 각 인덱스마다 동남쪽 방향으로 power x power 크기 만큼의 합 구하기
			// 합 구하면서 최대합 구하기
			int maxSum = 0; // 탐색한 합 중 최대합 저장할 변수

			for (int rowIdx = 0; rowIdx < mapSize; rowIdx++) {
				for (int colIdx = 0; colIdx < mapSize; colIdx++) {
					maxSum = Math.max(maxSum, findSum(rowIdx, colIdx));
				}
			}

			// 최대합 append
			sb.append("#").append(tc).append(" ").append(maxSum).append("\n");
		}

		System.out.println(sb);
	}

}
