import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스 입력받기
 * 2. 각 테스트 케이스별로 10개의 수 입력받기
 * 3. 입력받은 수 중에서 홀수만 더해서
 * 4. 값을 출력
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 입력받기
        int testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스별로
        for (int tc = 1; tc <= testCase; tc++) {

            // 10개의 수를 저장할 리스트 생성
            int[] numList = new int[10];

            // 10개의 수 입력받기
            st = new StringTokenizer(br.readLine().trim());
            for (int idx = 0; idx < 10; idx++) {
                numList[idx] = Integer.parseInt(st.nextToken());
            }

            // 홀수의 합을 저장할 변수 생성
            int sum = 0;

            // 입력받은 수 중에서 홀수만 더하기
            for (int idx = 0; idx < 10; idx++) {
                if (numList[idx] % 2 == 1) {
                    sum += numList[idx];
                }
            }

            // sum값 append
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        // 정답 출력
        System.out.println(sb);
    }
}
