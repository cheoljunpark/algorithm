import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 박철준
 * <p>
 * 1. 소문자인 문자열이 주어진다
 * 2. 문자열을 대문자로 바꾼다
 */
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

//        char[] arr = br.readLine().trim().toCharArray();    // 입력받은 문자열을 char 배열에 담기
//        for (char c : arr) {    // 배열에 각 문자 순회
//            if (c >= 'a' && c <= 'z') { // 문자가 소문자라면
//                System.out.print((char) (c - 'a' + 'A'));    // 대문자로 출력
//            } else {    // 문자가 소문자가 아니라면
//                System.out.print(c);    // 그대로 출력
//            }
//        }

        // String 클래스의 toUpperCase() 메소드 사용
        System.out.println(br.readLine().trim().toUpperCase());
    }
}
