import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int start = 0;
        int end = 0;
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }

        while (true) {
            try {
                if (sum == m) {
                    cnt++;
                    sum = sum + arr[++end] - arr[start++];
                } else if (sum < m) {
                    sum += arr[++end];
                } else {
                    sum -= arr[start++];
                }
            } catch (Exception e){
                break;
            }
        }

        System.out.println(cnt);
    }
}
