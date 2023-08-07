import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * ----------시간초과 뜸-------------
 * 1. 탑의 수(n)을 입력받는다 
 * 2. 탑의 수만큼 배열을 선언한다(top) 
 * 3. top배열의 각각의 높이를 입력받는다 
 * 4. 반복문을 돌면서 각 인덱스에서 왼쪽으로 가면서 
 *    자신의 높이보다 큰 값의 인덱스를 찾는다
 *
 *-----------스택 이용해서 다시 구현-----------------
 * 1. 스택이 비어있다면 0을 출력하고, 현재 탑을 스택에 push
 * 2. 스택이 비어있지 않다면, 아래 2가지 케이스를 검사
 * 	  2.1 스택에 peek한 탑 높이가 현재 탑보다 높다면, peek한 탑의 번호 출력하고, 현재 탑을 push
 *    2.2 스택에 peek한 탄 높이가 현재 탑보다 낮다면, peek한 탑을 pop하고 2번으로 돌아간다
 *
 *
 */

public class Main {

	public static void main(String[] args) throws IOException {
//		시간초과 뜸

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//
//		// 탑의 수(n) 입력받기
//		int n = Integer.parseInt(br.readLine().trim());
//
//		// 탑의 수만큼 배열(top) 선언
//		int[] top = new int[n];
//
//		// top배열 입력받기
//		StringTokenizer st = new StringTokenizer(br.readLine().trim());
//		for (int idx = 0; idx < top.length; idx++) {
//			top[idx] = Integer.parseInt(st.nextToken());
//		}
//
//		// 반복문을 돌면서 각 인덱스에서 왼쪽으로 가면서
//		// 자신의 높이보다 큰 값의 인덱스를 찾는다
//		for (int idx = 0; idx < top.length; idx++) {
//			int i = idx;
//			int height = top[idx];
//
//			while (i >= 0) {
//				if (i == 0) {
//					sb.append(i).append(" ");
//					break;
//				}
//				if (top[--i] > height) {
//					sb.append(i + 1).append(" ");
//					break;
//				}
//			}
//		}
//
//		System.out.println(sb);

		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 탑의 수(n) 입력받기
		int n = Integer.parseInt(br.readLine().trim());

		// 스택 선언
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();

		// 1. 스택이 비어있다면 0을 출력하고, 현재 탑을 스택에 push
		// 2. 스택이 비어있지 않다면, 아래 2가지 케이스를 검사
		// 2.1 스택에 peek한 탑 높이가 현재 탑보다 높다면, peek한 탑의 번호 출력하고, 현재 탑을 push
		// 2.2 스택에 peek한 탄 높이가 현재 탑보다 낮다면, peek한 탑을 pop하고 2번으로 돌아간다
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int idx = 1; idx <= n; idx++) {
			int height = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				sb.append(0).append(" ");
				stack.push(height);
				index.push(idx);
			} else {
				while (true) {
					if (stack.isEmpty()) {
						sb.append(0).append(" ");
						stack.push(height);
						index.push(idx);
						break;
					}

					int top = stack.peek();

					if (top > height) {
						sb.append(index.peek()).append(" ");
						stack.push(height);
						index.push(idx);
						break;
					} else {
						stack.pop();
						index.pop();
					}
				}
			}
		}

		System.out.println(sb);
	}

}
