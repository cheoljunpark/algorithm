import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스는 10개이다
 * 2. 각 테스트 케이스별로 정점의 총 수(n)을 입력받는다
 * 4. n개의 줄마다 각 노드 검사를 한다
 * 5. 검사
 *    5.1 리프 노드에는 숫자만 있어야한다
 *    5.2 리프노드가 아닌 곳에 숫자가 있으면 안된다
 *
 */

public class Solution {
	// 숫자인지 판별
	static boolean isNumeric(String target) {
		if (target.equals("1") || target.equals("2") || target.equals("3") || target.equals("4") || target.equals("5")
				|| target.equals("6") || target.equals("7") || target.equals("8") || target.equals("9")
				|| target.equals("0"))
			return true;
		return false;
	}

	// 연산자인지 판별
	static boolean isOperator(String target) {
		if (target.equals("+") || target.equals("-") || target.equals("*") || target.equals("/"))
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {

		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 0; tc < 10; tc++) {
			int n = Integer.parseInt(br.readLine().trim()); // 총 노드 수 입력받기
			int flag = 1; // 유효한지 여부

			for (int idx = 1; idx <= n; idx++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();

				// 리프노드는 "총 노드 수 / 2" 부터 시작
				String str = st.nextToken();
				if (idx > n / 2) { // 리프 노드가 숫자가 아니면 flag = 0
					if (!isNumeric(str)) {
						flag = 0;
					}
				} else { // 리프 노드가 아닌 노드가 연산자가 아니면 flag =0
					if (!isOperator(str)) {
						flag = 0;
					}
				}
			}

			sb.append("#").append(tc + 1).append(" ").append(flag).append("\n");
		}

		System.out.println(sb);
	}

}
