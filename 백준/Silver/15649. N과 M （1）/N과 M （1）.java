
import java.util.Scanner;

public class Main {
	// 순열 메소드
	// depth가 r만큼 될 때까지 재귀호출
	// 유도조건:
	// 1. 배열(arr)의 인덱스를 차례대로 순회한다
	// 2. arr의 원소가 뽑힌적 없다면(visited[i]가 false)라면
	// 3. visited[i]를 true로 바꿔주고
	// 4. 깊이(depth)에 해당하는 순열저장배열(output[depth])에 뽑은원소(arr[i])를 저장
	// 5. 다시 depth+1한 permutation 메소드 호출
	// 6. 재귀가 모두 호출 된 뒤, 다음 순열을 위해 visited[i]는 false로 바꿔준다.
	// 기저조건:
	// 1. depth가 r일때(r개가 뽑혔을때)
	// 2. 순열저장배열(output)을 출력
	static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {	// r개 뽑혔다면
			for (int idx = 0; idx < r; idx++) {
				System.out.print(output[idx] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {	// 뽑힌적이 없다면
				visited[i] = true;	// 뽑아주고
				output[depth] = arr[i];	// 뽑힌 수(arr[i])를 순열저장배열(ouput[depth])에 저장
				permutation(arr, output, visited, depth + 1, n, r); // depth를 하나 증가해서 재귀 호출
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();	// 문제에선 N
		int r = sc.nextInt();	// 문제에선 M

		int[] arr = new int[n];	// 1부터 n까지의 정수를 담은 배열
		int[] output = new int[n];	// 순열 저장 배열
		boolean[] visited = new boolean[n];	// 인덱스에 해당하는 숫자가 사용 중인지 저장하는 배열

		for (int idx = 0; idx < n; idx++) {
			arr[idx] = idx + 1;	// 배열에 1부터 n까지 차례대로 담는다
		}

		permutation(arr, output, visited, 0, n, r);	// 순열 메소드 호출
	}

}
