import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 문자열을 입력받는다
 * 3. 문자열을 Base64 decode 한다
 */

// 문제 요약
// 1. 표1을 보고 입력받은 문자들을 각각 대응하는 숫자로 변경한다.
// 2. 각 숫자들을 6자리 이진수로 표현하고, 이 이진수들을 한 줄로 쭉 이어 붙인다.
// 3. 한 줄로 쭉 이어붙인 이진수들을 8자리씩 끊어서 십진수로 바꾼다.
// 4. 각각의 십진수를 아스키 코드로 변환한다.

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 입력
        int testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스 별로
        for (int tc = 1; tc <= testCase; tc++) {

            // 문자열 입력받기
            String encodeStr = br.readLine().trim();

            // 문자열을 Base64 decode 한다
            String decodeStr = new String(Base64.getDecoder().decode(encodeStr));

            // 결과 append
            sb.append("#").append(tc).append(" ").append(decodeStr).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}