
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 정수 n과 k를 입력받는다
 * 2. deque에 1부터 n까지 순서대로 넣는다
 * 3. 1부터 순회하면서 deque가 빌때까지 k번째 요소를 삭제한다
 *
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken()); // 사람 수 (n) 입력받기
		int k = Integer.parseInt(st.nextToken()); // k번째 입력받기

		Deque<Integer> deque = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();

		// deque에 1부터 n까지 순서대로 넣기
		for (int i = 1; i <= n; i++) {
			deque.offerLast(i);
		}
		
		
		sb.append("<");
		// 1부터 순회하면서 deque가 빌때까지 k번째 요소 삭제하기
		while (deque.size() != 1) {
			for(int i = 0; i<k-1;i++) {
				deque.offerLast(deque.pollFirst());
			}
			sb.append(deque.pollFirst()).append(", ");
		}
		sb.append(deque.pollFirst()).append(">");
		// 대괄호를 꺽새로 바꾸기
//		sb.append("<").append(list.toString().substring(1, list.toString().length()-1)).append(">");
		System.out.println(sb);

	}

}
