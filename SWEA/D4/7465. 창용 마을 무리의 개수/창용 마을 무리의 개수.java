import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 사람의 수(personCnt), 관계의 수(relationCnt)를 입력받는다
 * 3. 관계의 수만큼 관계를 입력받는다
 *    3.1 앞의 수와 뒤의 수를 union한다
 * 4. root 배열의 각 인덱스에서 root를 찾아 HashSet에 저장한다
 * 5. HashSet의 사이즈를 출력 
 *
 */

public class Solution {
	static int[] root;

	static void union(int from, int to) {
		int rootFrom = find(from); // from의 root 찾기
		int rootTo = find(to); // to의 root 찾기

		if (rootFrom == rootTo) { // 이미 같은 그룹이라면 리턴
			return;
		}

		root[rootFrom] = rootTo; // rootFrom의 root를 rootTo로 바꾸기
	}

	static int find(int x) {
		if (root[x] == x) { // root를 찾았다면 root값 리턴
			return x;
		} else {
			return find(root[x]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테스트 케이스 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= testCase; tc++) {
			// 사람의 수(personCnt), 관계의 수(relationCnt)를 입력받는다
			st = new StringTokenizer(br.readLine().trim());
			int personCnt = Integer.parseInt(st.nextToken());
			int relationCnt = Integer.parseInt(st.nextToken());

			// root 배열 생성
			root = new int[personCnt + 1];

			// 처음엔 자기 자신을 가리키도록 한다
			for (int idx = 1; idx <= personCnt; idx++) {
				root[idx] = idx;
			}

			// 관계의 수만큼 관계를 입력받아
			// 두 사람의 번호를 union
			for (int relation = 0; relation < relationCnt; relation++) {
				st = new StringTokenizer(br.readLine().trim());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				union(from, to);
			}

			// root배열에서 root의 개수 세기(무리의 개수 구하기)
			HashSet<Integer> hs = new HashSet<>();
			for (int idx = 1; idx <= personCnt; idx++) {
				hs.add(find(idx));
			}

			// 무리의 개수 append
			sb.append("#").append(tc).append(" ").append(hs.size()).append("\n");
		}

		// 정답 출력
		System.out.println(sb);
	}

}
