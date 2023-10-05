import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 박철준
 * 
 * 1. 10개의 테스트 케이스 별로
 * 2. 가로 길이를 입력받는다
 * 3. 가로 길이만큼 배열을 선언한다
 * 4. 배열에 건물 길이를 입력받는다
 * 5. 인덱스 (2 ~ 가로길이-3)까지 조망권 확보한 세대를 구한다
 *    5.1 각 인덱스(idx)의 idx-2 ~ idx+2 중에 
 *        idx에 해당하는 값보다 큰 값이 있다면 continue(조망권 확보 실패)
 *    5.2 그렇지 않다면 idx에 해당하는 값을 idx-2 ~ idx+2에 해당하는 값 중에 
 *        가장 큰 값을 뺀다
 *    5.3 뺀 값을 조망권 확보 세대(sum)에 더한다
 * 6. 조망권 확보 세대 출력
 */

public class Solution {
	static int[] map;
	static int width;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// 10개의 테스트 케이스 별로
		for (int testCase = 1; testCase <= 10; testCase++) {

			// 가로 길이 입력받기
			width = Integer.parseInt(br.readLine().trim());

			// 가로 길이만큼 배열 선언
			map = new int[width];

			// 배열에 건물 길이 입력받기
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < map.length; idx++) {
				map[idx] = Integer.parseInt(st.nextToken());
			}

			// 조망권 확보 세대의 합을 저장할 변수 선언
			int sum = 0;

			/* 
			 * 인덱스 (2 ~ 가로길이-3)까지 조망권 확보한 세대를 구한다
			 *     각 인덱스(idx)의 idx-2 ~ idx+2 중에
			 *     idx에 해당하는 값보다 큰 값이 있다면 continue(조망권 확보 실패)
			 * 그렇지 않다면
			 *     idx에 해당하는 값을 idx-2 ~ idx+2에 해당하는 값 중에
			 *     가장 큰 값을 뺀다
			 * 뺀 값을 조망권 확보 세대(sum)에 더한다
			 */
			for (int idx = 2; idx < map.length - 2; idx++) {
				// 조망권 확보했는지 판별
				boolean flag = true;

				for (int idx2 = idx - 2; idx2 <= idx + 2; idx2++) {
					if (idx == idx2) {
						continue;
					}
					if (map[idx2] >= map[idx]) {
						flag = false;
						break;
					}
				}

				// 조망권 확보했다면 확보 세대 구하기
				int maxVal = 0;
				if (flag) {
					for (int idx2 = idx - 2; idx2 <= idx + 2; idx2++) {
						if (idx == idx2) {
							continue;
						}
						maxVal = Math.max(maxVal, map[idx2]);
					}
					sum += map[idx] - maxVal;
				}

			}

			// 조망권 확보 세대(sum) append
			sb.append("#").append(testCase).append(" ").append(sum).append("\n");
		}

		// 정답 출력
		System.out.println(sb);
	}

}
