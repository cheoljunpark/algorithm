import java.util.Scanner;

/**
 * 
 * @author 박철준
 *
 */

public class Main {
	static int recursionCnt;

	static String[] script = { 
			"어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.", 
			"\"재귀함수가 뭔가요?\"", 
			"\"재귀함수는 자기 자신을 호출하는 함수라네\"",
			"라고 답변하였지.", 
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", 
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"" 
			};

	static void dash(int depth) {
		for (int i = 0; i < depth * 4; i++) {
			System.out.print("_");
		}
	}

	static void recursion(int depth) {
		dash(depth);
		System.out.println(script[1]);
		if (depth == recursionCnt) {
			for (int idx = 2; idx <= 3; idx++) {
				dash(depth);
				System.out.println(script[idx]);
			}
			return;
		}
		for (int idx = 4; idx < script.length; idx++) {
			dash(depth);
			System.out.println(script[idx]);
		}
		recursion(depth + 1);
		dash(depth);
		System.out.println(script[3]);
	}

	public static void main(String[] args) {

		// 재귀 횟수 입력받기
		Scanner sc = new Scanner(System.in);
		recursionCnt = sc.nextInt();

		// 출력
		System.out.println(script[0]);
		recursion(0);
	}

}
