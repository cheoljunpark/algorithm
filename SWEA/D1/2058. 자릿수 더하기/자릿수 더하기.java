import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 자연수를 입력받아 char 배열(numList)에 저장
 * 2. numList를 순회해 Integer로 파싱해 각각의 값을 더한다
 * 3. 모두 더한 합 출력
 */
public class Solution {
    static int sum = 0;

    /**
     * numList를 순회해 Integer로 파싱해 각각의 값을 더하는 메소드
     *
     * @param numList 입력받은 수의 각 자릿수를 담은 char 배열
     */
    static void getSum(char[] numList) {
        for (char num : numList) {
            sum += Character.getNumericValue(num);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자연수를 입력받아 char 배열(numList)에 저장
        char[] numList = br.readLine().trim().toCharArray();

        // 각 자릿수의 합 구하기
        getSum(numList);

        // 합 출력
        System.out.println(sum);
    }
}
