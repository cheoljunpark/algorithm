import java.io.*;
import java.util.*;

/*
 * 1. N, K 입력받기
 * 2. belt 생성
 * 3. robot 생성
 * 4. 벨트 회전
 * 5. 로봇 이동
 * 6. 올리는 위치에 로봇 올림
 * 7. 내구도 0인 칸의 개수가 K개 이상이면 종료
 */
public class Main {
    static int[] belt;
    static boolean[] robot;
    static int N, K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[N * 2];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(process());
    }


    static int process() {
        int cnt = 0;

        while (isPossible()) {
            // 벨트 회전
            int tmp = belt[belt.length - 1];
            for (int i = belt.length - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = tmp;


            for (int i = robot.length - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false;

            // 로봇 이동
            for (int i = robot.length - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && belt[i] >= 1) {
                    belt[i]--;
                    robot[i] = true;
                    robot[i - 1] = false;
                }
            }

            // 올리는 위치에 로봇 올림
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }

            cnt++;
        }

        return cnt;
    }

    static boolean isPossible() {
        int cnt = 0;

        for (int i = 0; i < belt.length; i++) {
            if (belt[i] == 0) {
                cnt++;
            }

            if (cnt == K) {
                return false;
            }
        }

        return true;
    }
}
