import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 크기(n), 검색할 행 번호(r), 검색할 열 번호(c)를 입력받는다
 * 2. 인덱스 (r, c)가 몇 사분면에 있는지 검색해 분할정복한다
 * 3. 분할정복 과정
 *    3.1 사이즈를 4분면으로 나눈다
 *    3.2 인덱스가 있는 사분면에 이동
 *    3.3 이동하면서 앞 사분면들의 요소의 합을 더한다
 *    3.4 크기가 1x1일때까지 반복
 */

public class Main {
	static int n; // 배열 크기
	static int r; // 검색할 행
	static int c; // 검색할 열
	static int cnt = 0; // 이동한 횟수

	public static void findZ(int sr, int sc, int size) {
		// 배열의 크기가 1x1이라면
		if (size == 1) {
			return;
		}

		// 배열의 크기가 1x1이 아니라면
		// 1사분면 | 2사분면
		// -------------
		// 3사분면 | 4사분면
		int half = size / 2; // 사이즈를 반으로 줄여서 4분할

		if (sr < half && sc < half) { // 1사분면에 있다면
			findZ(sr, sc, half);
		} else if (sr < half && sc >= half) { // 2사분면에 있다면
			cnt += half * half; // 1사분면에 있던 요소의 개수 더하기
			findZ(sr, sc - half, half);
		} else if (sr >= half && sc < half) { // 3사분면에 있다면
			cnt += half * half * 2; // 1, 2사분면에 있던 요소의 개수 더하기
			findZ(sr - half, sc, half);
		} else { // 4사분면에 있다면
			cnt += half * half * 3; // 1, 2, 3사분면에 있던 요소의 개수 더하기
			findZ(sr - half, sc - half, half);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		n = Integer.parseInt(st.nextToken()); // 배열 크기 입력받기
		r = Integer.parseInt(st.nextToken()); // 검색할 인덱스 행 입력받기
		c = Integer.parseInt(st.nextToken()); // 검색할 인덱스 열 입력받기

		int size = (int) Math.pow(2, n); // 2^n으로 사이즈 만들기

		findZ(r, c, size); // 탐색

		System.out.println(cnt);
	}

}
