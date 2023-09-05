import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author 박철준
 * 
 * 1. 카드의 개수(cardCount)를 입력받는다
 * 2. 카드 리스트(cardList)에 1부터 cardCount까지 offerLast 해준다
 * 3. 제일 위에 있는 카드를 버리고 그 다음 카드를 맨 밑으로 넣는 메소드(discard)를 생성
 * 4. 3번을 카드 리스트의 사이즈가 1일 때까지 반복
 * 5. 마지막에 있는 카드를 출력
 *
 */

public class Main {
	static int cardCount;
	static Deque<Integer> cardList = new ArrayDeque<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void discard() { // 제일 위에 있는 카드를 버리고 그 다음 카드를 맨 밑으로 넣는 메소드
		cardList.pollFirst(); // 맨 위 카드 버리고
		int card = cardList.pollFirst(); // 그 다음 카드를
		cardList.offerLast(card); // 카드 리스트 맨 밑에 넣기
	}

	public static void main(String[] args) throws IOException {

		// 카드의 개수 입력받기
		cardCount = Integer.parseInt(br.readLine().trim());

		// 1부터 cardCount까지 카드 리스트에 offer
		for (int card = 1; card <= cardCount; card++) {
			cardList.offerLast(card);
		}

		// 카드 리스트에 카드가 1장 남을때까지 맨 위 카드 버리고 두번째 카드 맨 밑에 넣기
		while (cardList.size() != 1) {
			discard();
		}

		// 마지막 남은 카드 출력
		System.out.println(cardList.poll());
	}

}
