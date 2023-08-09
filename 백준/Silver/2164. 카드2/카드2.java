import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine().trim());

		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			deque.offerLast(i);
		}

		while (deque.size() != 1) {
			deque.pollFirst();
			int number = deque.pollFirst();
			deque.offerLast(number);
		}

		System.out.println(deque.peek());
	}
}
