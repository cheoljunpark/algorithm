import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 문자열을 입력받는다
 * 2. 문자열을 쪼개 배열에 담는다
 * 3. 배열의 각 문자를 숫자로 변환해서 출력
 *
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 문자열 입력받아서 쪼갠 것을 배열에 담기
        char[] str = br.readLine().trim().toCharArray();

        // 배열의 각 문자를 숫자로 변환해서 append
        for (char s : str) {
            sb.append(s - 'A' + 1).append(" ");
        }
        // 정답 출력
        System.out.println(sb);
    }
}
