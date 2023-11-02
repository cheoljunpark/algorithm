import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 10개의 수를 입력받는다
 * 3. 10개의 수 중 최댓값을 찾는다
 *
 */
public class Solution {
    static int max;

    /**
     * 리스트에서 최댓값을 찾는 메소드
     * 
     * @param numList 10개의 수가 담긴 배열
     */
    static void findMaxNum(int[] numList) {
        for (int num : numList) {
            max = Math.max(max, num);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스를 입력받는다
        int testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스별로
        for (int tc = 1; tc <= testCase; tc++) {

            // 10개의 수를 담을 배열 생성
            int[] numList = new int[10];

            // 10개의 수를 입력받는다
            st = new StringTokenizer(br.readLine().trim());
            for (int idx = 0; idx < 10; idx++) {
                numList[idx] = Integer.parseInt(st.nextToken());
            }

            // 최댓값 찾기
            max = Integer.MIN_VALUE;
            findMaxNum(numList);

            // 최댓값 append
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}
