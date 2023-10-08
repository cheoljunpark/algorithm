import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * @author 박철준
 * 
 * 1. 입력받을 수의 개수(numberCount)를 입력받는다
 * 2. numberCount개의 수를 입력받아 스택에 쌓는다
 * 3. 스택에 있는 숫자들을의 합을 저장할 변수(numberSum) 선언
 *    3.1 숫자가 0이면 스택에서 pop하면서 numberSum에서 빼기
 *    3.2 숫자가 0이 아니면 스택에 push하면서 numberSum에 더하기
 *
 */

public class Main {
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		// 입력받을 수의 개수(numberCount)를 입력받는다
		int numberCount = Integer.parseInt(br.readLine().trim());

		// 스택 생성
		Stack<Integer> stack = new Stack<>();

		// 스택에 있는 숫자들을의 합을 저장할 변수(numberSum) 선언
		int numberSum = 0;

		// numberCount개의 수를 입력받아 스택에 쌓는다
		for (int cnt = 0; cnt < numberCount; cnt++) {
			int number = Integer.parseInt(br.readLine().trim());

			if (number == 0) { // 숫자가 0이면 스택에서 pop하면서 numberSum에서 빼기
				numberSum -= stack.pop();
			} else { // 숫자가 0이 아니면 스택에 push하면서 numberSum에 더하기
				stack.push(number);
				numberSum += number;
			}
		}

		// numberSum 출력
		System.out.println(numberSum);
	}

}
