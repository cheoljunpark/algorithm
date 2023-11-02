/*
 * 1. 5x5 사이즈 크기의 맵에서
 * 2. (n, n) 위치에는 "#" 출력
 * 3. 그 외의 위치에는 "+" 출력
 */

public class Solution {
    static final int MAP_SIZE = 5;

    public static void main(String[] args) {
        // (n, n) 위치에는 "#" 출력
        // 그 외의 위치에는 "+" 출력
        for (int rowIdx = 0; rowIdx < MAP_SIZE; rowIdx++) {
            for (int colIdx = 0; colIdx < MAP_SIZE; colIdx++) {
                if (rowIdx == colIdx) {
                    System.out.print("#");
                    continue;
                }
                System.out.print("+");
            }
            System.out.println();
        }
    }
}
