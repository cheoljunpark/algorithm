import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스 별로 과자봉지개수(n)과 무게합제한(m)을 입력받는다
 * 3. n개의 과자 무게를 입력받는다.
 * 4. n개의 과자 중 2개를 선택한다(조합)
 * 5. 선택한 2개의 합이 m을 넘지 않는 최대 값을 구한다
 */

public class Solution {
	static int n, m;
	static int[] snack;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] list;
	static int maxWeight;

	static void comb(int start, int depth) {// 조합 메서드 : 시작점과 깊이 두가지를 파라미터로 담는다.
		if (depth == 2) {// 깊이가 M에 다다랐을때 기저조건
			if (list[0] + list[1] <= m) {
				maxWeight = Math.max(list[0] + list[1], maxWeight);
			}
			return;
		}

		for (int i = start; i < n; i++) { // 반복문을 start부터 시작하여 사전순으로 증가하는 배열이 된다.
			list[depth] = snack[i]; // 현재 위치에 숫자를 선택
			comb(i + 1, depth + 1); // 다음 위치로 이동 (재귀)
		}
	}

	public static void main(String[] args) throws IOException {

		// 테스트 케이스 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 0; tc < testCase; tc++) {

			// 과자봉지개수(n)과 무게합제한(m)을 입력받기
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			// n개의 과자 무게 입력받기
			snack = new int[n];
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < n; idx++)
				snack[idx] = Integer.parseInt(st.nextToken());

			list = new int[2];
			maxWeight = -1;
			// n개의 과자 중 2개를 선택하기(조합)
			comb(0, 0);

			sb.append("#").append(tc + 1).append(" ").append(maxWeight).append("\n");
		}
		System.out.println(sb);

	}

}
