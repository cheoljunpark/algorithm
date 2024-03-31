import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int sum, cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 배열 생성
        arr = new int[N];

        // 배열 입력받기
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(arr);

        // 더하기
        int firstMaxNum = arr[N - 1];
        int secondMaxNum = arr[N - 2];

        for (int i = 0; i < M; i++) {
            if (cnt == K) {
                cnt = 0;
                sum += secondMaxNum;
                continue;
            }

            sum += firstMaxNum;
            cnt++;
        }

        // 출력
        System.out.println(sum);
    }
}
