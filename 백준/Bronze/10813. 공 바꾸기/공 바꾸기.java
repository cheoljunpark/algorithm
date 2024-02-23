import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 바구니의 수
        int M = scanner.nextInt(); // 공을 바꿀 횟수

        // 바구니 초기화 (1~N까지 번호 매기기)
        int[] baskets = new int[N];
        for (int i = 0; i < N; i++) {
            baskets[i] = i + 1;
        }

        // M번 공 바꾸기
        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt() - 1; // 교환할 바구니 1 (인덱스는 0부터 시작하므로 -1)
            int y = scanner.nextInt() - 1; // 교환할 바구니 2 (인덱스는 0부터 시작하므로 -1)
            // 공 교환
            int temp = baskets[x];
            baskets[x] = baskets[y];
            baskets[y] = temp;
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(baskets[i] + " ");
        }

        scanner.close();
    }
}
