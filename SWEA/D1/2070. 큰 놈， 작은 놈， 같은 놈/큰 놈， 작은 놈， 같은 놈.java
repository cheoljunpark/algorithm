import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스 별로 두 수(num1, num2)를 입력받는다
 * 3. 두 수의 크기를 비교하여 등호 또는 부등호를 출력
 */
public class Solution {
    /**
     * 두 수를 비교하여 등호 또는 부등호를 결정하는 메소드
     *
     * @param num1 첫 번째 숫자
     * @param num2 두 번째 숫자
     * @return 등호 또는 부등호
     */
    static String compare(int num1, int num2) {
        if (num1 > num2) {
            return ">";
        } else if (num1 < num2) {
            return "<";
        } else {
            return "=";
        }
    }

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

            // 두 수의 크기를 비교하여 등호 또는 부등호 append
            String str = compare(num1, num2);
            sb.append("#").append(tc).append(" ").append(str).append("\n");
        }
        // 정답 출력
        System.out.println(sb);
    }
}
