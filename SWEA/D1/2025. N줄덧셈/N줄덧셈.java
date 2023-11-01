import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 숫자를 입력받는다
 * 2. 1부터 숫자까지의 합 알고리즘 n*(n+1)/2를 사용해 정답 출력
 */
public class Solution {
    /**
     * 1부터 주어진 숫자까지의 합을 출력하는 메소드
     *
     * @param number 입력받은 숫자
     */
    static void printSumOneToNum(int number) {
        System.out.println(number * (number + 1) / 2);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 입력
        int number = Integer.parseInt(br.readLine().trim());

        // 1부터 숫자까지의 합 알고리즘
        printSumOneToNum(number);
    }
}
