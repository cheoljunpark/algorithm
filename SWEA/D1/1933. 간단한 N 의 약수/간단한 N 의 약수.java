import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 정수(number)를 입력받는다
 * 2. number의 약수를 출력한다
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 정수(number) 입력받기
        int number = Integer.parseInt(br.readLine().trim());

        // number의 약수 구하기
        for (int idx = 1; idx <= number; idx++) {
            if (number % idx == 0) {
                sb.append(idx).append(" ");
            }
        }

        // 정답 출력
        System.out.println(sb);
    }

}