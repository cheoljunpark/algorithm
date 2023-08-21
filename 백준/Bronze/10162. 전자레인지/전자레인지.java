import java.util.Scanner;

/**
 * 
 * @author 박철준
 * 
 * 1. 요리시간(time)을 입력받는다
 * 2. A, B, C 버튼의 시간이 담긴 배열(button)을 생성한다
 * 3. 각 버튼이 누른 횟수를 담을 배열(buttonPressed)을 만든다
 * 3. time을 각 버튼으로 나눈 몫을 buttonPressed에 담는다 
 * 4. 모두 나눈 뒤에 time이 0이 아니라면 -1 출력
 * 
 *
 */

public class Main {

	public static void main(String[] args) {
		// 요리 시간(time) 입력받기
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();

		// 버튼 배열 생성
		int[] button = { 300, 60, 10 }; // A: 300초(5분), B: 60초(1분), C: 10초

		// 버튼 누른 횟수 배열 생성
		int[] buttonPressed = new int[3];

		// time을 각 버튼으로 나눈 몫을 buttonPressed에 담기
		for (int buttonIdx = 0; buttonIdx < button.length; buttonIdx++) {
			buttonPressed[buttonIdx] = time / button[buttonIdx];
			time %= button[buttonIdx];
		}

		// 출력
		if (time == 0) { // 시간이 3개의 버튼으로 맞출 수 "있는" 숫자라면
			for (int pressedCnt : buttonPressed) {
				System.out.print(pressedCnt + " ");
			}
		} else { // 시간이 3개의 버튼으로 맞출 수 "없는" 숫자라면
			System.out.println(-1);
		}

	}

}
