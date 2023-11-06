import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스 별로 10개의 수를 입력받아 리스트에 담는다
 * 3. 최대 수와 최소 수를 제외하고 나머지의 평균을 구한다
 *
 */

public class Solution {
    static int testCase;
    static int[] numList;
    static int maxNum, minNum;
    static int sum, avg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 입력
        testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스별로
        for (int tc = 1; tc <= testCase; tc++) {

            // 10개의 수를 담을 리스트 생성
            numList = new int[10];

            // 최대 수, 최소 수를 구할 변수 생성
            maxNum = Integer.MIN_VALUE;
            minNum = Integer.MAX_VALUE;

            // 10개의 수 입력받기
            st = new StringTokenizer(br.readLine().trim());
            for (int idx = 0; idx < 10; idx++) {
                numList[idx] = Integer.parseInt(st.nextToken());
                maxNum = Math.max(maxNum, numList[idx]);    // 최대수 구하기
                minNum = Math.min(minNum, numList[idx]);    // 최소수 구하기
            }

            // 최대수와 최소수를 제외한 나머지의 평균값 구하기
            sum = 0;
            for (int idx = 0; idx < 10; idx++) {
                if (numList[idx] == maxNum || numList[idx] == minNum) {
                    continue;
                }
                sum += numList[idx];
            }
            avg = (int) Math.round((double) sum / 8);

            // 평균값 append
            sb.append("#").append(tc).append(" ").append(avg).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}
