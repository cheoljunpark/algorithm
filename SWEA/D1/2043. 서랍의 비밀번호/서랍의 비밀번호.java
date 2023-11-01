import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 비밀번호(password)와 주어진 비밀번호(givenPassword)를 입력받는다
 * 2. password - givenPassword + 1 을 출력
 */
public class Solution {
    /**
     * givenPassword부터 1씩 증가하여 몇 번만에 password를 맞추는지 구하는 메소드
     *
     * @param password 비밀번호
     * @param givenPassword 주어진 비밀번호
     */
    static void findPasswordCnt(int password, int givenPassword) {
        System.out.println(password - givenPassword + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 비밀번호와 주어진 비밀번호 입력받기
        st = new StringTokenizer(br.readLine().trim());
        int password = Integer.parseInt(st.nextToken());
        int givenPassword = Integer.parseInt(st.nextToken());

        // 비밀번호 맞추는 횟수 출력하기
        findPasswordCnt(password, givenPassword);
    }
}
