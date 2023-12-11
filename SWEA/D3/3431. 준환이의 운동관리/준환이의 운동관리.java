import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스 별로 최소운동시간(minExerciseTime), 최대운동시간(maxExerciseTime), 운동한시간(exerciseTime)을 입력받는다
 * 3. 운동시간에 따른 추가 운동 시간을 계산한다
 *    3.1 exerciseTime > maxExerciseTime이라면 "-1" 출력
 *    3.2 minExerciseTime <= exerciseTime <= maxExerciseTime이라면 "0" 출력
 *    3.3 exerciseTime < minExerciseTieml이라면 "(minExerciseTime - exerciseTime)" 출력
 */

public class Solution {
    static int minExerciseTime, maxExerciseTime, exerciseTime;
    static int testCase;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    /**
     * 운동 결과를 반환하는 메소드
     *
     * @return 필요한 양보다 더 많은 운동을 하고 있다면 -1, 적절하게 하고 있다면 0, 부족하다면 추가로 운동해야 하는 시간
     */
    static int getResult() {
        int result = 0;

        if (exerciseTime > maxExerciseTime) {
            result = -1;
        } else if (exerciseTime >= minExerciseTime && exerciseTime <= maxExerciseTime) {
            result = 0;
        } else {
            result = minExerciseTime - exerciseTime;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        // 테스트 케이스를 입력받는다
        testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스 별로
        for (int tc = 1; tc <= testCase; tc++) {

            // 최소운동시간(minExerciseTime), 최대운동시간(maxExerciseTime), 운동한시간(exerciseTime)을 입력받기
            st = new StringTokenizer(br.readLine().trim());
            minExerciseTime = Integer.parseInt(st.nextToken());
            maxExerciseTime = Integer.parseInt(st.nextToken());
            exerciseTime = Integer.parseInt(st.nextToken());

            // 운동시간에 따른 추가 운동 시간을 계산한다
            int result = getResult();

            // 결과 append
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}