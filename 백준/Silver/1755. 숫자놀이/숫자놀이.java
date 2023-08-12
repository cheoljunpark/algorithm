import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 정수 m과 n을 입력받는다.
 * 2. m부터 n까지 각 정수를 문자열로 변환한 값을 우선순위 큐에 넣는다
 * 3. comparable을 재정의한다.
 *    3.1 문자열 기준으로 정렬
 * 4. 우선순위큐에 있는 요소를 10개씩 출력
 *     
 *
 */

class Number implements Comparable<Number> { // comparable을 implements 해줌으로써 내가 원하는 방식으로 정렬할 수 있도록 한다
	String s;
	int n;

	public Number(String s, int n) {
		super();
		this.s = s;
		this.n = n;
	}

	@Override
	public int compareTo(Number o) {
		// string만 가지고 사전순 정렬
		return s.compareTo(o.s);
	}

}

public class Main {
	public static void main(String[] args) throws IOException {
		// 숫자를 영어로 바꾼 것을 미리 배열에 담아둠
		String[] num = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// m과 n 입력
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		// 우선순위큐 생성 -> 자동정렬
		PriorityQueue<Number> pq = new PriorityQueue<>();

		// m부터 n까지 우선순위큐에 넣기
		for (int i = m; i <= n; i++) {
			String s = "";
			if (i < 10) {
				s = num[i];
			} else {
				s += num[i / 10];
				s += num[i % 10];
			}
			pq.offer(new Number(s, i));
		}

		// 우선순위큐에 요소를 10개씩 출력
		int cnt = 0;
		while (!pq.isEmpty()) {
			Number number = pq.poll();
			sb.append(number.n).append(" ");
			cnt++;
			if (cnt % 10 == 0) {
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

}
