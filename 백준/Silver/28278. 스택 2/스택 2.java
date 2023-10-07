import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 명령의 수(commandCount)를 입력받는다
 * 2. commandCount개의 명령을 입력받을 때,
 *    각 명령의 결과를 출력
 */

public class Main {
	static Stack<Integer> stack;
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static void doCommand() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		
		int commandNumber = Integer.parseInt(st.nextToken());
		int number = 0;
		if(st.hasMoreTokens()) {
			number = Integer.parseInt(st.nextToken());
		}
		
		switch(commandNumber) {
		case 1:
			stack.push(number);
			break;
		case 2:
			if(!stack.isEmpty()) {
				sb.append(stack.pop()).append("\n");
			} else {
				sb.append(-1).append("\n");
			}
			break;
		case 3:
			sb.append(stack.size()).append("\n");
			break;
		case 4:
			if(stack.isEmpty()) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
			break;
		case 5:
			if(!stack.isEmpty()) {
				sb.append(stack.peek()).append("\n");
			} else {
				sb.append(-1).append("\n");
			}
			break;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		// 스택 생성
		stack = new Stack<>();
		
		// 명령어 개수 입력받기
		int commandCount = Integer.parseInt(br.readLine().trim());
		
		
		// 명령어 개수 만큼 명령 입력받기
		for (int command = 0; command < commandCount; command++) {
			// 명령어에 따라 명령 수행
			doCommand();
		}
		
		// 정답 출력
		System.out.println(sb);
	}

}
