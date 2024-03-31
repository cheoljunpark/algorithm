import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int maxNum = 1;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 맵 생성
        map = new int[N][M];

        // 맵 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 맵의 각 행 정렬
        for (int i = 0; i < N; i++) {
            Arrays.sort(map[i]);
        }

        // 맵의 각 행의 첫 번째 숫자 중에서 최대 구하기
        for (int i = 0; i < N; i++) {
            maxNum = Math.max(maxNum, map[i][0]);
        }

        // 출력
        System.out.println(maxNum);
    }
}
