import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 스위치(switchCnt)의 개수를 입력 받는다
 * 2. 크기가 switchCnt인 스위치 배열(switchArr)을 만든다
 * 3. swtichArr을 입력받는다
 * 4. 학생 수(studentCnt)을 입력받는다
 * 5. 학생 수 만큼 성별(sex), 번호(number)를 입력받는다
 * 6. 성별에 따라서 스위치를 변경한다
 *
 */

public class Main {
	static int switchCnt; // 스위치 개수
	static int[] switchArr; // 스위치 배열
	static int studentCnt; // 학생 수
	static int sex, number; // 성별, 번호

	static void changeSwitch(int idx) {	// 스위치 0과 1바꾸는 메소드
		if (switchArr[idx] == 0) {
			switchArr[idx] = 1;
		} else {
			switchArr[idx] = 0;
		}
	}

	static void change(int sex, int number) { // 성별,번호에 따라 스위치 바꾸기
		if (sex == 1) { // 남자라면
			maleChangeSwitch(number);
		} else { // 여자라면
			femaleChangeSwitch(number);
		}
	}

	static void maleChangeSwitch(int number) {	// 남자일때 스위치 바꾸는 메소드
		for (int idx = number; idx <= switchCnt; idx += number) {	// 번호의 배수마다
			changeSwitch(idx);	// 스위치 바꾸기
		}
	}

	static void femaleChangeSwitch(int number) {	// 여자일때 스위치 바꾸는 메소드
		int leftIdx, rightIdx;
		leftIdx = rightIdx = number;
		
		// 주어진 번호로 부터 양 옆으로 대칭일 때까지의 왼쪽 인덱스, 오른쪽 인덱스 찾기
//		while(leftIdx>=1&&rightIdx<=) {
//			if (switchArr[leftIdx] != switchArr[rightIdx]) {
//				break;
//			}
//		}
		for (leftIdx = number, rightIdx = number; leftIdx >= 1 && rightIdx <= switchCnt; leftIdx--, rightIdx++) {
			if (switchArr[leftIdx] != switchArr[rightIdx]) {
				break;
			}
		}
		
		// break 탈출하면 왼쪽 인덱스와 오른쪽 인덱스가 하나씩 벗어난 상태이므로 조정하기
		leftIdx++;
		rightIdx--;
		
		// 대칭 구간 스위치 바꾸기
		for (int idx = leftIdx; idx <= rightIdx; idx++) {
			changeSwitch(idx);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 스위치 개수 입력받기
		switchCnt = Integer.parseInt(br.readLine().trim());

		// 스위치 배열 생성
		switchArr = new int[switchCnt + 1];

		// 스위치 배열 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int idx = 1; idx <= switchCnt; idx++) {
			switchArr[idx] = Integer.parseInt(st.nextToken());
		}

		// 학생 수 입력받기
		studentCnt = Integer.parseInt(br.readLine().trim());

		// 학생 수 마다 정보 입력받기
		for (int student = 0; student < studentCnt; student++) {
			st = new StringTokenizer(br.readLine().trim());
			sex = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken());

			change(sex, number);
		}

		// 스위치 출력
		for (int idx = 1; idx <= switchCnt; idx++) {
			System.out.print(switchArr[idx] + " ");
			if(idx%20==0) {
				System.out.println();
			}
		}
	}

}
