package com.ssafy.ws.step2;

import java.util.Scanner;

/**
 * 
 * @author 박철준
 * 1. 크기(n)을 입력 받는다
 * 2. nXn 크기의 map배열을 만들어 영양분을 입력받는다
 * 3. 각 요소를 돌면서 (현재위치 영양분+상하좌우 영양분)의 합을 구한다
 * 4. 이 때, 배열의 크기를 벗어난 위치의 영양분은 더하지 않는다
 * 5. 최대 영양분을 구해서 출력한다
 *
 */
public class AppleTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] map = new int[n][n];

		// 상하좌우 순서
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		// 영양분
		int nutrition = 0;
		// 최대 영양분
		int maxNutrition = 0;

		for (int row = 0; row < n; row++) {
			for (int column = 0; column < n; column++) {
				map[row][column] = sc.nextInt();
			}
		}

		for (int row = 0; row < n; row++) {


			for (int column = 0; column < n; column++) {
				// 각 위치마다 nutrition 0으로 초기화
				nutrition = 0;
				
				// 현재 위치 영양분 더하기
				nutrition += map[row][column];
				
				// 상화좌우 영양분 더하기
				for (int i = 0; i < 4; i++) {
					int nr = row + dx[i];
					int nc = column + dy[i];
					if ((nr >= 0 && nr < n) && (nc >= 0 && nc < n)) {
						nutrition += map[nr][nc];
					}
				}
				
				// 더한 영양분이 최대 영양분 보다 크다면 최대 영양분 교체
				if (nutrition > maxNutrition) {
					maxNutrition = nutrition;
				}
			}
		}

		// 최대 영양분 출력
		System.out.println(maxNutrition);

		sc.close();
	}
}
