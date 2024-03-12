import java.io.*;
import java.util.*;

/*
 * 1. gear int[4][8] 선언
 * 2. isMovable[4] 선언
 * 3. CLOCKWISE = 1, COUNTER_CLOCKWISE = -1
 * 4. 톱니번호와 회전방향 입력받기
 * 5. 입력받은 톱니바퀴 기준으로 오른쪽과 왼쪽 회전여부 검사
 * 6. 회전
 *    6.1 회전 가능 여부에 따라 회전한다
 * 7. 점수 계산
 */

public class Main {
    static int[][] gear;
    static boolean[] isMovable;
    static int[] moveDirection;
    static int rotateCnt, rotateDirection;
    static int gearNumber;
    static final int CLOCKWISE = 1;
    static final int COUNTER_CLOCKWISE = -1;
    static final int S = 1;

    static void checkMovable(int n, int direction) {
        // n 기준 오른쪽 톱니 회전 여부 검사
        for (int i = gearNumber; i < 3; i++) {
            if (gear[i][2] != gear[i + 1][6]) {
                isMovable[i + 1] = true;
                moveDirection[i + 1] = (-1) * moveDirection[i];
            } else {
                break;
            }
        }
        // n 기준 왼쪽 톱니 회전 여부 검사
        for (int i = gearNumber; i >= 1; i--) {
            if (gear[i][6] != gear[i - 1][2]) {
                isMovable[i - 1] = true;
                moveDirection[i - 1] = (-1) * moveDirection[i];
            } else {
                break;
            }
        }
    }

    static void rotate() {
        for (int i = 0; i < 4; i++) {
            if (moveDirection[i] == CLOCKWISE) {
                int temp = gear[i][7];
                for (int j = 7; j >= 1; j--) {
                    gear[i][j] = gear[i][j - 1];
                }
                gear[i][0] = temp;
            } else if (moveDirection[i] == COUNTER_CLOCKWISE) {
                int temp = gear[i][0];
                for (int j = 0; j < 7; j++) {
                    gear[i][j] = gear[i][j + 1];
                }
                gear[i][7] = temp;
            }
        }
    }

    static int getScore() {
        int score = 0;

        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == S) {
                score += (int) Math.pow(2, i);
            }
        }

        return score;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 톱니 선언
        gear = new int[4][8];


        // 톱니바퀴 정보 입력받기
        for (int i = 0; i < 4; i++) {
            String str = br.readLine().trim();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = str.charAt(j) - '0';
            }
        }

        // 회전 횟수 입력받기
        rotateCnt = Integer.parseInt(br.readLine().trim());

        // 각 회전 마다 움직일 톱니 번호, 방향 입력받기
        for (int rotate = 0; rotate < rotateCnt; rotate++) {
            st = new StringTokenizer(br.readLine().trim());
            gearNumber = Integer.parseInt(st.nextToken()) - 1;
            rotateDirection = Integer.parseInt(st.nextToken());

            // 회전 가능 여부 배열 선언
            isMovable = new boolean[4];
            moveDirection = new int[4];

            // 입력받은 톱니 번호에 대한 정보 저장
            isMovable[gearNumber] = true;
            moveDirection[gearNumber] = rotateDirection;

            // 톱니 회전 여부 검사
            checkMovable(gearNumber, rotateDirection);

            // 톱니 회전
            rotate();
        }

        // 점수 얻기
        int score = getScore();

        // 점수 출력
        System.out.println(score);
    }

}
