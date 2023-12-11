import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스 별로 첫번째 시간과 두번째 시간을 입력받는다
 * 3. 자정에서 첫번째 시간과 두번째 시간이 지났을 때 24시간제의 시간을 출력한다
 *    3.1 첫번째 시간과 두번째 시간을 더한다
 *    3.2 24로 나눈 나머지를 출력
 */

public class Solution {
    static int testCase;
    static int timeA, timeB;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // 테스트 케이스를 입력받는다
        testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스 별로
        for (int tc = 1; tc <= testCase; tc++) {

            // 첫번째 시간과 두번째 시간을 입력받는다
            st = new StringTokenizer(br.readLine().trim());
            timeA = Integer.parseInt(st.nextToken());
            timeB = Integer.parseInt(st.nextToken());

            // 첫번째 시간과 두번째 시간을 더해서 24로 나눈 나머지를 append
            sb.append("#").append(tc).append(" ").append((timeA + timeB) % 24).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}
