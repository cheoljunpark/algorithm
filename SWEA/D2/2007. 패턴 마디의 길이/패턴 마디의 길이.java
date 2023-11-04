import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스 별로 문자열을 입력받는다
 * 3. 마디의 최대 길이가 10이므로 마디를 1 ~ 10까지 차례대로 세팅해
 *    세팅한 길이의 마디마다 반복되는지 확인
 * 4. 반복된다면 해당 마디를 출력
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 입력
        int testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스 별로
        for (int tc = 1; tc <= testCase; tc++) {

            // 문자열 입력받기
            String str = br.readLine().trim();

            // 마디의 최대 길이가 10이므로 마디를 1 ~ 10까지 차례대로 세팅해
            // 세팅한 길이의 마디마다 반복되는지 확인
            for (int idx = 1; idx <= 10; idx++) {
                String subStr = str.substring(0, idx);
                if (subStr.equals(str.substring(idx, idx * 2))) {    // 반복된다면 해당 마디를 append
                    sb.append("#").append(tc).append(" ").append(idx).append("\n");
                    break;
                }
            }
        }

        // 정답 출력
        System.out.println(sb);
    }
}
