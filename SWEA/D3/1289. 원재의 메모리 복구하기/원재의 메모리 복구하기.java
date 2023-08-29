import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스(testCase)를 입력받는다
 * 2. 각 테스트 케이스별로 원래의 메모리 값(originalMemory)을 입력받아 int형 배열에 넣는다
 * 3. 초기화된 배열(initMemory)을 생성한다
 * 4. initMemory와 originalMemory의 각 인덱스에 해당하는
 *    값을 비교해서 다르면 해당 인덱스 부터 initMemory의 끝 인덱스까지 값을 바꾼다
 * 5. 값을 바꾼 횟수(changeCnt)를 계산한다  
 *
 */

public class Solution {
	static int[] originalMemory, initMemory; // 원래 메모리, 초기 메모리
	static int changeCnt; // 수정 횟수

	static boolean isEqual() { // 원래 메모리와 초기 메모리가 동일해 졌는지 확인하는 메소드
		for (int idx = 0; idx < originalMemory.length; idx++) {
			if (originalMemory[idx] != initMemory[idx]) {
				return false;
			}
		}
		return true;
	}

	static void change(int idx, int number) { // 해당 인덱스에서부터 끝까지 원래 메모리 값의 숫자로 바꾸기
		for (int initMemoryIdx = idx; initMemoryIdx < initMemory.length; initMemoryIdx++) {
			initMemory[initMemoryIdx] = number;
		}
	}

	public static void main(String[] args) throws IOException {

		// 테스트 케이스 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= testCase; tc++) {
			// 원래 메모리 값 입력받아서 크기만큼 배열 생성
			String[] str = br.readLine().trim().split("");
			originalMemory = new int[str.length];

			// 원래 메모리 값 넣어주기
			for (int idx = 0; idx < originalMemory.length; idx++) {
				originalMemory[idx] = Integer.parseInt(str[idx]);
			}

			// 초기화된 메모리 배열 생성
			initMemory = new int[str.length];

			// initMemory와 originalMemory의 각 인덱스 비교해서 값 바꾸기
			// 값 바뀔 때마다 수정 횟수 계산
			changeCnt = 0; // 수정 횟수 0으로 초기화

			for (int idx = 0; idx < originalMemory.length; idx++) {
				// initMemory와 originalMemory의 각 인덱스에 해당하는 값을 비교해서 다르면 해당 인덱스 부터 initMemory의 끝
				// 인덱스까지 값을 바꾼다
				if (originalMemory[idx] != initMemory[idx]) {
					int number = originalMemory[idx]; // 원래 메모리의 값을 number에 저장해 파라미터로 넘겨주기
					change(idx, number); // 초기 메모리 값 바꾸기
					changeCnt++; // 수정 횟수 증가
					if (isEqual()) { // 초기화된 메모리가 원래 메모리와 동일해 졌다면
						break;
					}
				}

			}

			// 수정 횟수 출력
			System.out.println("#" + tc + " " + changeCnt);
		}
	}

}
