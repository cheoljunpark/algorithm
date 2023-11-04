import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스 별로 합을 저장할 변수(sum) 생성
 * 3. 10개의 수를 입력아 sum에 더한다
 * 4. 평균값(sum/10)을 구한다
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

            // 합을 저장할 변수 생성
            int sum = 0;

            // 10개의 수 입력받기
            st = new StringTokenizer(br.readLine().trim());
            for (int idx = 0; idx < 10; idx++) {
                sum += Integer.parseInt(st.nextToken());
            }

            // 리스트의 평균 구하기
            int avg = (int) Math.round((double) sum / 10);

            // avg 값 append
            sb.append("#").append(tc).append(" ").append(avg).append("\n");
        }
        // 정답 출력
        System.out.println(sb);
    }
}
