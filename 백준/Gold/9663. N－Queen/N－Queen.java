import java.util.Scanner;

/**
 * 
 * @author 박철준
 * 
 * 1. 크기(n)를 입력받는다
 * 2. 크기 n인 1차원 배열을 만든다 (인덱스가 열, 값이 행)
 * 3. 0열의 각 행마다 백트래킹
 * 4. 백트래킹 과정
 *    4.1 n-1열까지 간다면 원소를 다 채운거니까 방법개수(cnt) 증가하고 return
 *    4.2 각 열의 행마다 검사
 *    4.3 놓을 수 있다면 다음 열에서 재귀호출
 * 5. 검사 과정
 *    5.1 해당 열의 행과 i열의 행이 일치할경우 false 리턴
 *    5.2 대각선상에 놓인 경우 false 리턴
 *    5.3 둘다 아니면 true 리턴
 *    
 *
 */

public class Main {
	static int n;
	static int[] arr;
	static int cnt;

	public static void nQueen(int col) {
		if (col == n) {	// 모든 열에 다 배치를 한거면 방법 개수 증가 및 return
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			arr[col] = i;
			if (isPossible(col)) {	// 놓을 수 있다면 재귀호출
				nQueen(col + 1);
			}
		}
	}

	public static boolean isPossible(int col) {

		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) {	// 같은 행에 존재할 경우
				return false;
			} else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {	// 대각선 위치에 존재할 경우
				return false;
			}

		}

		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 크기(n) 입력
		arr = new int[n]; // 배열 생성

		nQueen(0);
		System.out.println(cnt);
	}
}
