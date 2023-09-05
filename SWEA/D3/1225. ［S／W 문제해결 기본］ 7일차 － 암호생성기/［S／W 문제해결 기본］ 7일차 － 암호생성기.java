import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 10개의 테스트 케이스 별로 8개의 암호(password)를 입력받아서 암호 리스트(passwordList)에 넣는다
 * 2. 암호 리스트에 0이 없는 동안 사이클을 돌린다
 *    2.1 암호 리스트에 첫 암호를 차례대로 1씩, 2씩, 3씩, 4씩, 5씩 감소하고
 *    2.2 암호를 암호 리스트 맨 뒤로 넣는다
 *    2.3 암호가 0 이하 값이 되면 0으로 만들고 flag를 false로 변경하고 사이클 중단
 * 3. 암호를 출력
 *
 */

public class Solution {
	static Deque<Integer> passwordList;
	static boolean flag;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static void cycle() {
		for (int cycleCnt = 1; cycleCnt <= 5; cycleCnt++) {
			int password = passwordList.pollFirst();
			password -= cycleCnt; // 암호 리스트에 첫 암호를 차례대로 1씩, 2씩, 3씩, 4씩, 5씩 감소하고
			if (password <= 0) { // 암호가 0 이하 값이 되면 0으로 만들고 flag를 false로 변경하고 사이클 중단
				password = 0;
				passwordList.offerLast(password);
				flag = false;
				return;
			}
			passwordList.offerLast(password); // 암호를 암호 리스트 맨 뒤로 넣는다
		}
	}

	public static void main(String[] args) throws IOException {

		for (int testCase = 1; testCase <= 10; testCase++) {
			// 테스트 케이스 번호 입력받기(쓸 데 없어서 날리기..)
			br.readLine().trim();

			// 암호 리스트 생성
			passwordList = new ArrayDeque<>();

			// 8개의 암호(password)를 입력받아서 암호 리스트(passwordList)에 넣기
			st = new StringTokenizer(br.readLine().trim());
			for (int password = 0; password < 8; password++) {
				passwordList.offerLast(Integer.parseInt(st.nextToken()));
			}

			// 암호 리스트에 0이 없는 동안 사이클을 돌린다
			flag = true;
			while (flag) {
				cycle();
			}

			// 최종 암호 append
			sb.append("#").append(testCase).append(" ");
			while (!passwordList.isEmpty()) {
				sb.append(passwordList.pollFirst()).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
