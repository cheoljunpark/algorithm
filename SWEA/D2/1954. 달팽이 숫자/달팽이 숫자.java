import java.util.Scanner;
 
/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스(testCase)를 입력받는다
 * 2. 각 테스트 케이스별로 달팽이의 크기(n)을 입력받고
 * 3. nXn 행렬(arr)과 방문했는지 여부를 판단하는 nXn행렬 (visited)를 선언한다
 * 4. 시계방향으로 돌면서 1부터 차례대로 배열에 저장한다
 * 5. n까지 저장이 되었다면 완료
 *
 */
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int testCase = sc.nextInt(); // 테스트 케이스 개수
 
        for (int tc = 0; tc < testCase; tc++) {
            int n = sc.nextInt(); // 달팽이의 크기
 
            int[][] arr = new int[n][n];
            boolean[][] visited = new boolean[n][n]; // 방문했는지 여부 배열
 
            int rowIdx = 0; // 시계방향으로 돌 때 행 인덱스
            int colIdx = 0; // 시계방향으로 돌 때 열 인덱스
            int cnt = 1; // 1부터 n까지 차례대로 증가하면서 저장할 변수
 
            while (cnt != n * n + 1) { // 1부터 n까지 다 저장할때까지
 
                // 오른쪽으로 가기
                while (colIdx < n && visited[rowIdx][colIdx] == false) { // 달팽이 크기만큼 and 방문하지않은곳으로 가기
                    visited[rowIdx][colIdx] = true; // 방문표시
                    arr[rowIdx][colIdx++] = cnt++;
                }
                colIdx--;   // 오른쪽으로 가면서 범위를 벗어나서 열 인덱스 감소
                rowIdx++;   // 열 인덱스 감소하면 이미 방문했던 곳으로 되어있어서 행 인덱스 증가
 
                // 아래로 가기
                while (rowIdx < n && visited[rowIdx][colIdx] == false) { // 달팽이 크기만큼 and 방문하지않은곳으로 가기
                    visited[rowIdx][colIdx] = true; // 방문표시
                    arr[rowIdx++][colIdx] = cnt++;
                }
                rowIdx--;   // 아래로 가면서 범위를 벗어나서 행 인덱스 감소
                colIdx--;   // 행 인덱스 감소하면 이미 방문했던 곳으로 되어있어서 열 인덱스 감소
 
                // 왼쪽으로 가기
                while (colIdx >= 0 && visited[rowIdx][colIdx] == false) {    // 달팽이 크기만큼 and 방문하지않은곳으로 가기
                    visited[rowIdx][colIdx] = true; // 방문표시
                    arr[rowIdx][colIdx--] = cnt++;
                }
                colIdx++;   // 왼쪽으로 가면서 범위를 벗어나서 열 인덱스 증가
                rowIdx--;   // 열 인덱스 증가하면 이미 방문했던 곳으로 되어있어서 행 인덱스 감소
 
                // 위로 가기
                while (rowIdx > 0 && visited[rowIdx][colIdx] == false) { // 달팽이 크기만큼 and 방문하지않은곳으로 가기
                    visited[rowIdx][colIdx] = true; // 방문표시
                    arr[rowIdx--][colIdx] = cnt++;
                }
                rowIdx++;   // 위로 가면서 범위를 벗어나서 행 인덱스 증가
                colIdx++;   // 행 인덱스 증가하면 이미 방문했던 곳으로 되어있어서 열 인덱스 증가
            }
 
            // 배열 출력
            System.out.println("#" + (tc + 1));
            for (int row = 0; row < arr.length; row++) {
                for (int col = 0; col < arr[row].length; col++) {
                    System.out.print(arr[row][col] + " ");
                }
                System.out.println();
            }
 
        }
 
    }
 
}