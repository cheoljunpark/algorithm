import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 숫자(number)를 입력받는다
 * 3. 크기가 10인 배열(numList)을 생성한다(이 때 각 인덱스는 0 ~ 9가 나온 횟 수)
 * 4. number를 쪼개서 각 숫자를 인덱스로하는 numList의 값을 증가 시킨다
 * 5. numList에 0이 없을 때 까지 number를 정수배한다
 * 6. 정수배한 횟 수를 출력
 */
public class Solution {
    static int testCase;
    static int number;
    static int originalNumber;
    static int[] numList;
    static int cnt;

    /**
     * 리스트에 0이 있는지 판별하는 메소드
     *
     * @param numList 리스트
     * @return 0이 있으면 true,<br>
     * 0이 없으면 false
     */
    static boolean check(int[] numList) {
        for (int n : numList) {
            if (n == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 입력
        testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스별로
        for (int tc = 1; tc <= testCase; tc++) {

            // 숫자(number) 입력받기
            number = Integer.parseInt(br.readLine().trim());
            originalNumber = number;

            // 크기가 10인 배열(numList)을 생성한다(이 때 각 인덱스는 0 ~ 9가 나온 횟 수)
            numList = new int[10];

            // 양 센 횟 수 초기화
            cnt = 0;

            // numList에 0이 없을 때 까지
            while (check(numList)) {
                String[] str = Integer.toString(number).split("");  // number를 쪼개서
                for (String s : str) {
                    numList[Integer.parseInt(s)]++; // 각 숫자를 인덱스로하는 numList의 값을 증가 시킨다
                }
                number += originalNumber;   // number를 정수배하고
                cnt++;  // 양을 센 횟 수 증가
            }

            // 센 횟수 append
            sb.append("#").append(tc).append(" ").append(originalNumber * cnt).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}
