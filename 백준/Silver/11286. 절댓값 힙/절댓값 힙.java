import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author 박철준
 *
 * 1. 연산의 개수(n)를 입력받는다
 * 2. 연산의 개수(n)만큼 정수(x)를 입력받는다
 * 3. 정수(x)가 0이 아니라면 우선순위큐에 넣는다
 * 4. 정수(x)가 0이라면 절댓값이 가장 작은 것을 출력하고
 *    절댓값이 작은 것이 여러개라면 가장 작은 수를 출력
 * 5. 우선순위 큐가 비어 있는 경우 0이 입력된다면 0을 출력 
 */

public class Main {

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 연산의 개수 (n) 입력받기
		int n = Integer.parseInt(br.readLine().trim());

		// 우선순위큐 선언
		// comparator 재정의
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((Integer o1, Integer o2) -> {
			if (Math.abs(o1) < Math.abs(o2)) {
				return -1;
			} else if (Math.abs(o1) > Math.abs(o2)) {
				return 1;
			} else {
				if (o1 > o2) {
					return 1;
				} else if (o1 < o2) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		// 연산의 개수(n)만큼 정수(x) 입력받기
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine().trim());
			if (x != 0) { // 정수(x)가 0이 아니라면 우선순위 큐에 넣기
				priorityQueue.add(x);
			} else { // 정수(x)가 0이라면 조건에 맞게 꺼내고 출력
				if (priorityQueue.isEmpty()) {
					sb.append(0).append("\n");
					continue;
				}
				sb.append(priorityQueue.poll()).append("\n");
			}
		}

		System.out.println(sb);

	}

}
