import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스 별로 두 수(num1, num2)를 입력받는다
 * 3. num1를 num2로 나눈 몫과 나머지를 출력한다
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

            // 두 수 입력받기
            st = new StringTokenizer(br.readLine().trim());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            // 몫과 나머지 구해서 append
            sb.append("#").append(tc).append(" ").append(num1 / num2).append(" ").append(num1 % num2).append("\n");

        }
        // 정답 출력
        System.out.println(sb);
    }
}
