import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 숫자(number)를 입력받는다
 * 2. 2^0부터 2^number까지 출력
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 숫자 입력
        int number = Integer.parseInt(br.readLine().trim());

        // 2^0부터 2^number까지 append
        for (int idx = 0; idx <= number; idx++) {
            sb.append((int) Math.pow(2, idx)).append(" ");
        }

        // 정답 출력
        System.out.println(sb);
    }
}
