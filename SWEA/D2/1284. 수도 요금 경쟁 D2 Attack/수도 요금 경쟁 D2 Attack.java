import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로
 *    """
 *    A사 1L당 요금(feeA),
 *    B사 기본요금(basicFeeB), B사 기준(basic), B사 1L당 요금(feeB)
 *    한 달간 사용한 수도의 양(water)
 *    """
 *    를 입력받는다
 * 3. A사 총 요금(totalFeeA): feeA * water
 *    B사 총 요금(totalFeeB): water < basic 이라면 -> basicFeeB
 *                          water > basic 이라면 -> basicFeeB + (water-basic)*feeB
 */

public class Solution {
    static int testCase;
    static int feeA;
    static int basicFeeB, basic, feeB;
    static int water;
    static int totalFeeA, totalFeeB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 입력받기
        testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스별로
        for (int tc = 1; tc <= testCase; tc++) {

            // 정보 입력받기
            st = new StringTokenizer(br.readLine().trim());
            feeA = Integer.parseInt(st.nextToken());
            basicFeeB = Integer.parseInt(st.nextToken());
            basic = Integer.parseInt(st.nextToken());
            feeB = Integer.parseInt(st.nextToken());
            water = Integer.parseInt(st.nextToken());

            // A사 총 요금
            totalFeeA = feeA * water;

            // B사 총 요금
            if (water < basic) {
                totalFeeB = basicFeeB;
            } else {
                totalFeeB = basicFeeB + (water - basic) * feeB;
            }

            // 요금이 더 적게 나온 것 append
            sb.append("#").append(tc).append(" ").append(Math.min(totalFeeA, totalFeeB)).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}
