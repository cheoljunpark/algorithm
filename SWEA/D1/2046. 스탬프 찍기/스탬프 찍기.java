import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 숫자를 입력받는다
 * 2. 입력받은 숫자만큼 "#" 출력
 */
public class Solution {
    /**
     * 숫자만큼 "#"를 출력하는 메소드
     *
     * @param number 입력받은 숫자
     */
    static void printHash(int number) {
        for (int idx = 0; idx < number; idx++) {
            System.out.print("#");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 입력받기
        int number = Integer.parseInt(br.readLine().trim());

        // 입력받은 숫자만큼 "#" 출력
        printHash(number);
    }
}
