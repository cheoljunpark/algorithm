import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 박철준
 * 
 * 1. 9개의 숫자를 담을 배열을 선언한다
 * 2. 9개의 숫자를 입력받는다
 * 3. 9개 중 7개의 숫자를 선택했을 때 합이 100이 되는 숫자들을 출력한다 -> 조합 사용
 *
 */

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	static int elementCount = 9;
	static int selectCount = 7;

	static int[] elementList;
	static int[] selectList;

	public static void combination(int elementIdx, int selectIdx) {
		// 기저 조건_1 로직
		// 모든 원소를 선택했으면 종료
		if (selectIdx == selectCount) {
			int sum = 0;	// 고른 수들의 합 저장할 변수
			for (int idx = 0; idx < selectList.length; idx++) {
				sum+=selectList[idx];
			}
			if(sum == 100) {	// 고른 수들의 합이 100이라면
				for (int idx = 0; idx < selectList.length; idx++) {
					sb.append(selectList[idx]).append("\n");
				}
			}
			return;
		}

		// 기저 조건_2 로직
		// 모든 원소를 확인했다면 종료
		if (elementIdx == elementCount) {
			return;
		}

		// 진행 조건 로직
		// 원소를 선택하고 넘어가기
		selectList[selectIdx] = elementList[elementIdx];
		combination(elementIdx + 1, selectIdx + 1);

		// 원소를 선택하지 않고 넘어가기
		selectList[selectIdx] = 0; // 초기화
		combination(elementIdx + 1, selectIdx);

	}

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 9개의 원소를 갖는 배열 선언
		elementList = new int[elementCount];

		// 7개를 선택해서 담을 배열 선언
		selectList = new int[selectCount];

		// 9개의 숫자를 입력받아서 배열에 저장
		for (int idx = 0; idx < elementCount; idx++) {
			elementList[idx] = Integer.parseInt(br.readLine().trim());
		}

		// 조합 생성
		combination(0, 0);

		// 출력
		System.out.println(sb);
	}

}
