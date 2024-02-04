import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 5개의 수를 입력받는다
 * 2. 각 수를 제곱한 뒤 더한다
 * 3. 그 수를 10으로 나눈 나머지를 출력한다
 */
public class Main {
    static int[] arr;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        arr = new int[5];

        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());
            sum += arr[idx] * arr[idx];
        }

        System.out.println(sum % 10);
    }

}
