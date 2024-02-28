import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1. row, column 입력받기
 * 2. 맵 생성
 * 3. 맵 입력 받기
 * 4. 육지('L')에서 bfs 탐색
 *    4.1 이동경로가 가장 큰 것 찾기
 */
public class Main {
    static int row, column;
    static char[][] map;
    static boolean[][] visited;
    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Pos {
        int x;
        int y;
        int distance;

        Pos(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static int bfs(int rowIdx, int colIdx) {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(rowIdx, colIdx, 0));
        visited[rowIdx][colIdx] = true;

        int distance = 0;
        while (!q.isEmpty()) {
            Pos current = q.poll();

            for (int[] dir : DIR) {
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];
                if (isMovable(nx, ny)) {
                    q.offer(new Pos(nx, ny, current.distance + 1));
                    visited[nx][ny] = true;
                    distance = Math.max(distance, current.distance + 1);
                }
            }
        }

        return distance;
    }

    static boolean isMovable(int nx, int ny) {
        return (0 <= nx && nx < row && 0 <= ny && ny < column) && (map[nx][ny] == 'L') && !visited[nx][ny];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        // row, column 입력받기
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        // 맵 생성
        map = new char[row][column];

        // 맵 입력받기
        for (int rowIdx = 0; rowIdx < row; rowIdx++) {
            String str = br.readLine().trim();
            for (int colIdx = 0; colIdx < column; colIdx++) {
                map[rowIdx][colIdx] = str.charAt(colIdx);
            }
        }

        // 각 인덱스에서 bfs 탐색
        int maxDistance = 0;
        for (int rowIdx = 0; rowIdx < row; rowIdx++) {
            for (int colIdx = 0; colIdx < column; colIdx++) {
                if (map[rowIdx][colIdx] == 'L') {
                    visited = new boolean[row][column];
                    int distance = bfs(rowIdx, colIdx);
                    maxDistance = Math.max(maxDistance, distance);
                }
            }
        }

        // 출력
        System.out.println(maxDistance);
    }
}
