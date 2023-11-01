import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 숫자를 입력받는다
 * 3. 숫자를 소인수분해 했을 때 지수를 출력한다
 *    3.1 소수 2, 3, 5, 7, 11을 담은 배열(primeNumList)을 생성
 *    3.2 primeNumList가 나온 횟수를 담을 배열(primeNumCntList) 생성
 *    3.3 숫자가 1이 될 때까지
 *    3.4 숫자를 primeNumList의 각 원소로 나눠서 나누어 떨어지면 primeNumCntList의 인덱스 증가
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 입력
        int testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스 별로
        for (int tc = 1; tc <= testCase; tc++) {
            // 숫자 입력받기
            int number = Integer.parseInt(br.readLine().trim());

            // 소수 2, 3, 5, 7, 11을 담은 배열(primeNumList)을 생성
            int[] primeNumList = {2, 3, 5, 7, 11};

            // primeNumList가 나온 횟수를 담을 배열(primeNumCntList) 생성
            int[] primeNumCntList = new int[5];

            // 숫자가 1이 될 때까지
            // 숫자를 primeNumList의 각 원소로 나눠서 나누어 떨어지면 primeNumCntList의 인덱스 증가
            while (number != 1) {
                for (int idx = 0; idx < primeNumList.length; idx++) {
                    if (number % primeNumList[idx] == 0) {
                        primeNumCntList[idx]++;
                        number /= primeNumList[idx];
                    }
                }
            }

            // primeNumCntList append
            sb.append("#").append(tc).append(" ");
            for (int idx = 0; idx < primeNumCntList.length; idx++) {
                sb.append(primeNumCntList[idx]).append(" ");
            }
            sb.append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}
