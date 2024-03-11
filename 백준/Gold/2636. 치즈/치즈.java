import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int CHEESE = 1;
    static int row, column;
    static int[][] map;
    static boolean[][] visited;
    static int cnt, cheese;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isEmpty() {
        for (int rowIdx = 0; rowIdx < row; rowIdx++) {
            for (int colIdx = 0; colIdx < column; colIdx++) {
                if (map[rowIdx][colIdx] == CHEESE) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isPossible(int nx, int ny) {
        return 0 <= nx && nx < row && 0 <= ny && ny < column && !visited[nx][ny];
    }

    static void bfs(Pos pos) {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(pos);
        visited[pos.x][pos.y] = true;

        while (!q.isEmpty()) {
            Pos now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isPossible(nx, ny)) {
                    if (map[nx][ny] == CHEESE) {
                        map[nx][ny] = 2;
                        visited[nx][ny] = true;
                    }
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new Pos(nx, ny));
                    }
                }

            }
        }

        removeCheese();
    }

    static void removeCheese() {
        for (int rowIdx = 0; rowIdx < row; rowIdx++) {
            for (int colIdx = 0; colIdx < column; colIdx++) {
                if (map[rowIdx][colIdx] == 2) {
                    map[rowIdx][colIdx] = 0;
                }
            }

        }
    }

    static int findCheese() {
        int cheese = 0;

        for (int rowIdx = 0; rowIdx < row; rowIdx++) {
            for (int colIdx = 0; colIdx < column; colIdx++) {
                if ((map[rowIdx][colIdx] == CHEESE)) {
                    cheese++;
                }
            }

        }

        return cheese;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        map = new int[row][column];
        visited = new boolean[row][column];

        for (int rowIdx = 0; rowIdx < row; rowIdx++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int colIdx = 0; colIdx < column; colIdx++) {
                map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
            }
        }

        while (!isEmpty()) {
            cnt++;
            cheese = findCheese();
            bfs(new Pos(0, 0));

            for (int i = 0; i < row; i++) {
                Arrays.fill(visited[i], false);
            }
        }

        System.out.println(cnt);
        System.out.println(cheese);
    }
}
