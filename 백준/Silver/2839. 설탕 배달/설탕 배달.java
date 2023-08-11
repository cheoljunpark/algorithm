import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author 박철준
 * 
 * 1. 설탕 5kg, 3kg가 들은 배열을 만든다
 * 2. 배달해야하는 설탕 무게(n)을 입력받는다
 * 3. 무게가 처음부터 5kg로 나누어 떨어지면 바로 계산하지만 그렇지 않다면 4번으로 간다
 * 4. 무게가 5kg 나누어 떨어질때까지 3kg을 뺀다
 * 5. 3kg씩 빼다가 5kg로 나누어 떨어지면 종료
 * 6. 3kg씩 빼다가 5kg로 나누어 떨어지지도 않고 음수가 된다면
 *    3kg와 5kg로 만들 수 없다는 수 이므로 "-1" 출력
 *
 */

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		// 설탕 무게 입력받기
		int n = sc.nextInt();	
		
		// 설탕 봉지 개수 카운트 변수
		int sugarCount = 0;
		
		// 설탕 봉지 개수 카운트
		while (n > 0) {
			if (n % 5 == 0) {	// 5로 나누어 떨어진다면
				sugarCount += n / 5;
				break;
			} else {
				n -= 3;	// 5로 나누어 떨어질 때까지 3빼기
				sugarCount++;
			}
		}

		if (n < 0) {
			System.out.println(-1);	// 3kg와 5kg로 만들 수 없는 무게라면
		} else {
			System.out.println(sugarCount);
		}
	}

}
