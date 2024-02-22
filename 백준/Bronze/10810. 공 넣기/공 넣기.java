import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // N과 M을 입력받음
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        // 바구니를 나타내는 배열을 생성하고 0으로 초기화
        int[] baskets = new int[N];
        
        // M번의 조작을 수행
        for (int m = 0; m < M; m++) {
            int i = scanner.nextInt() - 1; // 배열 인덱스는 0부터 시작하므로 1을 뺌
            int j = scanner.nextInt() - 1; // 배열 인덱스는 0부터 시작하므로 1을 뺌
            int k = scanner.nextInt();
            
            // i번 바구니부터 j번 바구니까지 k번 공을 넣음
            for (int b = i; b <= j; b++) {
                baskets[b] = k;
            }
        }
        
        // 결과 출력
        for (int b = 0; b < N; b++) {
            System.out.print(baskets[b] + " ");
        }
    }
}
