import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, L;
    static int cnt;
    static List<Star> starList = new ArrayList<>();

    static class Star {
        int x, y;

        Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        // N, M, K, L 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 별똥별 입력받아서 리스트에 넣기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            starList.add(i, new Star(x, y));
        }

        // 각 별똥별의 위치에 트램펄린 설치해 튕길 수 있는 별똥별 개수(cnt) 구하기
        for (Star star1 : starList) {
            for (Star star2 : starList) {
                cnt = Math.max(cnt, bound(star1.x, star2.y));
            }
        }

        // K - cnt 출력
        System.out.println(K - cnt);
    }

    static int bound(int i, int j) {
        int boundCnt = 0;

        // 스타리스트에서 하나씩 추출
        for (int k = 0; k < starList.size(); k++) {
            Star star = starList.get(k);
            int x = star.x;
            int y = star.y;
            if (i <= x && x <= i + L && j <= y && y <= j + L) {
                boundCnt++; // 스타의 x좌표 y좌표가 rowIdx< x< rowIdx+L, colIdx<y<colIdx+L 라면 int successCnt 증가
            }
        }

        return boundCnt;
    }
}
