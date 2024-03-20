import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, d, k, c;
    static int[] arr, visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new int[d + 1];

        System.out.println(slide());
    }

    static int slide() {
        int inSlide = 0, chance;
        
        // 처음 k개의 슬라이드에 담기
        for (int i = 0; i < k; i++) {
            if (visited[arr[i]] == 0) {
                inSlide++;
            }
            visited[arr[i]]++;
        }
        chance = inSlide;
        
        // 슬라이드 이동
        for (int i = 1; i < n; i++) {
            if (chance <= inSlide) {
                if (visited[c] == 0) {
                    chance = inSlide + 1;
                } else {
                    chance = inSlide;
                }
            }
            // 앞쪽 스시 계산
            visited[arr[i - 1]]--;
            if (visited[arr[i - 1]] == 0) {
                inSlide--;
            }
            // 뒤쪽 스시 계산
            if (visited[arr[(i + k - 1) % n]] == 0) {
                inSlide++;
            }
            visited[arr[(i + k - 1) % n]]++;
            
            // 현재 상태에서 쿠폰 초밥을 포함한 최대 종류 수 갱신
            int currentMax = inSlide + (visited[c] == 0 ? 1 : 0);
            chance = Math.max(chance, currentMax);
        }
        return chance;
    }
}