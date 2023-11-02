import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 숫자(number)를 입력받는다
 * 3. 1부터 number까지 홀수는 더하고 짝수는 뺀 값을 구한다
 */
public class Solution {
    /**
     * 1부터 number까지 홀수는 더하고 짝수는 빼는 메소드
     *
     * @param number 연산의 마지막 숫자
     * @return 연산의 결과
     */
    static int getResult(int number) {
        int result = 0;

        for (int num = 1; num <= number; num++) {
            if (num % 2 == 1) {
                result += num;
            } else {
                result -= num;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 입력
        int testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스별로
        for (int tc = 1; tc <= testCase; tc++) {
            // 숫자(number)를 입력받는다
            int number = Integer.parseInt(br.readLine().trim());

            // 1부터 number까지 홀수는 더하고 짝수는 뺀 값을 구한다
            int result = getResult(number);

            // 결과 append
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        // 정답 출력
        System.out.println(sb);
    }
}
