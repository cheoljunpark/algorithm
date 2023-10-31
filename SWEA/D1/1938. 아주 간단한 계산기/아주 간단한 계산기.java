import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 두 자연수를 입력받는다
 * 2. 사칙연산 +, -, *, / 순으로 연산 결과를 출력
 */
public class Solution {
    /**
     * 사칙연산 결과를 출력해주는 메소드
     *
     * @param number1 첫 번째 숫자
     * @param number2 두 번째 숫자
     */
    static void operation(int number1, int number2) {
        System.out.println(number1 + number2);
        System.out.println(number1 - number2);
        System.out.println(number1 * number2);
        System.out.println(number1 / number2);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 두 수 입력받기
        st = new StringTokenizer(br.readLine().trim());
        int number1 = Integer.parseInt(st.nextToken());
        int number2 = Integer.parseInt(st.nextToken());

        // 사칙연산
        operation(number1, number2);
    }
}
