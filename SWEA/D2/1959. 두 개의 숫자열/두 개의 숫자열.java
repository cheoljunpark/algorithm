import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 numListA와 numListB의 크기를 입력받는다
 * 3. numListA와 numListB를 생성
 * 4. numListA를 입력받는다
 * 5. numListB를 입력받는다
 * 6. numListA와 numListB 중 작은 리스트를 사이즈의 차만큼 반복해서
 *    각 요소들의 곱의 합의 최대를 구한다
 */

public class Solution {
    static int testCase;
    static int[] numListA, numListB;
    static int numListASize, numListBSize;
    static int result;
    static int maxResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스를 입력받는다
        testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스 별로
        for (int tc = 1; tc <= testCase; tc++) {

            // numListASize와 numListBSize를 입력받는다
            st = new StringTokenizer(br.readLine().trim());
            numListASize = Integer.parseInt(st.nextToken());
            numListBSize = Integer.parseInt(st.nextToken());

            // numListA와 numListB를 생성
            numListA = new int[numListASize];
            numListB = new int[numListBSize];

            // numListA를 입력받는다
            st = new StringTokenizer(br.readLine().trim());
            for (int idx = 0; idx < numListASize; idx++) {
                numListA[idx] = Integer.parseInt(st.nextToken());
            }

            // numListB를 입력받는다
            st = new StringTokenizer(br.readLine().trim());
            for (int idx = 0; idx < numListBSize; idx++) {
                numListB[idx] = Integer.parseInt(st.nextToken());
            }

            // 최대 결과값 초기화
            maxResult = 0;

            // numListA와 numListB 중 작은 리스트를 사이즈의 차만큼 반복해서
            // 각 요소들의 곱의 합의 최대를 구한다
            for (int cnt = 0; cnt <= Math.max(numListASize, numListBSize) - Math.min(numListASize, numListBSize); cnt++) {
                result = 0; // 결과값 초기화

                for (int idx = 0; idx < Math.min(numListASize, numListBSize); idx++) {
                    if (numListASize < numListBSize) {
                        result += numListA[idx] * numListB[idx + cnt];
                    } else {
                        result += numListA[idx + cnt] * numListB[idx];
                    }
                }

                maxResult = Math.max(maxResult, result);
            }

            // maxResult append
            sb.append("#").append(tc).append(" ").append(maxResult).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}
