import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        while (N != 1) {
            if (N % K == 0) {
                N /= K;
                cnt++;
                continue;
            }
            N--;
            cnt++;
        }

        System.out.println(cnt);
    }
}
