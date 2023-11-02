import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 두 수를 입력 받는다
 * 2. 가위바위보 이기는 경우:
 *    가위 < 바위
 *    바위 < 보
 *    보 < 가위
 */
public class Solution {
    static final int SCISSORS = 1;
    static final int ROCK = 2;
    static final int PAPER = 3;
    static int winner;

    /**
     * 가위바위보의 승자를 구하는 메소드
     *
     * @param personA A의 숫자
     * @param personB B의 숫자
     */
    static void play(int personA, int personB) {
        // personA가 가위일 때
        if (personA == SCISSORS) {
            if (personB == ROCK) {    // personB가 바위일때
                winner = personB;
            } else { // personB가 보일때
                winner = personA;
            }
        }
        // personA가 바위일 때
        else if (personA == ROCK) {
            if (personB == PAPER) {   // personB가 보일때
                winner = personB;
            } else { // personB가 가위일때
                winner = personA;
            }
        }
        // personA가 보일 때
        else {
            if (personB == SCISSORS) {    // personB가 가위일때
                winner = personB;
            } else { // personB가 바위일때
                winner = personA;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 두 수 입력받기
        st = new StringTokenizer(br.readLine().trim());
        int personA = Integer.parseInt(st.nextToken());
        int personB = Integer.parseInt(st.nextToken());

        // 가위바위보하기
        play(personA, personB);

        // 승자 출력
        if (winner == personA) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }
}
