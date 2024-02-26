import java.util.Scanner;

public class Main {
    static final int MOD = 1000000000;
    static final int FULL_MASK = (1 << 10) - 1; // 0부터 9까지 모든 숫자를 사용했음을 나타내는 비트 마스크
    static long[][][] dp;

    private static void initialize(int n) {
        dp = new long[n + 1][10][FULL_MASK + 1];
        for (int digit = 1; digit <= 9; digit++) {
            dp[1][digit][1 << digit] = 1;
        }
    }

    private static void calculateStairNumbers(int n) {
        for (int length = 1; length < n; length++) {
            for (int digit = 0; digit < 10; digit++) {
                for (int mask = 0; mask <= FULL_MASK; mask++) {
                    if (dp[length][digit][mask] == 0) continue;
                    // 다음 숫자가 digit-1이 될 때
                    if (digit > 0) {
                        int nextMask = mask | (1 << (digit - 1));
                        dp[length + 1][digit - 1][nextMask] = (dp[length + 1][digit - 1][nextMask] + dp[length][digit][mask]) % MOD;
                    }
                    // 다음 숫자가 digit+1이 될 때
                    if (digit < 9) {
                        int nextMask = mask | (1 << (digit + 1));
                        dp[length + 1][digit + 1][nextMask] = (dp[length + 1][digit + 1][nextMask] + dp[length][digit][mask]) % MOD;
                    }
                }
            }
        }
    }

    private static long findTotalStairNumbers(int n) {
        long total = 0;
        for (int digit = 0; digit < 10; digit++) {
            total = (total + dp[n][digit][FULL_MASK]) % MOD;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        initialize(n);
        calculateStairNumbers(n);
        System.out.println(findTotalStairNumbers(n));
    }
}
