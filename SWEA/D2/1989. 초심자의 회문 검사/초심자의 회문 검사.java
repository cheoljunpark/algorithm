import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 문자열(word)를 입력받는다
 * 3. word가 palindrome인지 검사해 회문이면 1, 아니면 0 출력
 */

public class Solution {
    static int testCase;
    static String[] word;
    static int result;

    /**
     * 회문인지 검사하는 메소드
     *
     * @return 회문이면 true<br>
     * 회문이 아니면 false
     */
    static boolean isPalindrome() {
        int mid = word.length / 2;

        for (int idx = 0; idx < mid; idx++) {
            if (!word[idx].equals(word[word.length - 1 - idx])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 입력
        testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스별로
        for (int tc = 1; tc <= testCase; tc++) {

            // 문자열(word) 입력받기
            word = br.readLine().trim().split("");

            // 회문인지 검사해서 맞으면 1, 아니면 0 append
            if (isPalindrome()) {
                result = 1;
            } else {
                result = 0;
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}
