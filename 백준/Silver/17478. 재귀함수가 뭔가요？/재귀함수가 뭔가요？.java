import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 박철준
 * 
 * 1. 재귀 함수 호출 횟수(recursionCnt)를 입력받는다
 * 2. 최초 구문(어느 한 컴퓨터공학과~) 출력
 * 3. 재귀 함수를 recursionCnt번 호출한다
 *    3.1 재귀 함수에서는 (재귀함수가 뭔가요? ~ 선비가 찾아와서 물었어)까지 출력
 * 4. 재귀가 끝나면 (재귀함수는 자기 자신을 호출하는 함수라네 ~ 라고 답변하였지) 출력
 * 
 */

public class Main {
	static int recursionCnt; // 재귀함수 호출 횟수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
	static StringBuilder sb = new StringBuilder(); // 출력

	static String[] script = { "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n",
			"\"재귀함수가 뭔가요?\"\n",
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
			"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n",
			"라고 답변하였지.\n" 
			};

	static void underBar(int depth) { // 재귀 호출 마다 언더바 append해주는 메소드
		for (int i = 0; i < depth; i++) {
			sb.append("____");
		}
	}

	static void recursion(int depth) {
		// 기저 조건
		if (depth == recursionCnt) {
			for (int idx : new int[] { 1, 5, 6 }) {
				underBar(depth);
				sb.append(script[idx]);
			}
			return;
		}

		// 진행 조건
		// (재귀함수가 뭔가요? ~ 선비가 찾아와서 물었어)까지 append
		for (int idx = 1; idx <= 4; idx++) {
			underBar(depth);
			sb.append(script[idx]);
		}

		recursion(depth + 1);

		// 기저조건 처리 후(return된 후) 실행 되는 영역
		// (라고 답변하였지) append
		underBar(depth);
		sb.append(script[6]);

	}

	public static void main(String[] args) throws IOException {

		// 재귀 횟수 입력받기
		recursionCnt = Integer.parseInt(br.readLine().trim());

		// 최초 구문 append
		sb.append(script[0]);

		// 재귀함수 호출
		recursion(0);

		// 정답 출력
		System.out.println(sb);
	}

}
