import java.io.*;
import java.util.*;

/*
 * 1. row, column 입력받기
 * 2. 맵 생성
 * 3. 맵 입력받기
 * 4. (0,0)에서 bfs 탐색
 *     4.1 우선순위큐 사용
 *     4.2 (row, column)에 도달하면 cnt return
 */

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int row, column;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pos implements Comparable<Pos> {
        int x, y, cnt;

        Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pos o) {
            return cnt - o.cnt;
        }
    }

    static boolean isPossible(int nx, int ny) {
        return 0 <= nx && nx < row && 0 <= ny && ny < column && !visited[nx][ny];
    }

    static int bfs(Pos pos) {
        Queue<Pos> q = new PriorityQueue<>();
        q.offer(pos);
        visited[pos.x][pos.y] = true;

        while (!q.isEmpty()) {
            Pos now = q.poll();

            // 도착했으면 종료
            if (now.x == row - 1 && now.y == column - 1) {
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isPossible(nx, ny)) {
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new Pos(nx, ny, now.cnt));
                    } else if (map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.offer(new Pos(nx, ny, now.cnt + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        // row, column 입력받기
        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        // 맵 생성
        map = new int[row][column];

        // visited 생성
        visited = new boolean[row][column];


        // 맵 입력받기
        for (int rowIdx = 0; rowIdx < row; rowIdx++) {
            String line = br.readLine().trim();
            for (int colIdx = 0; colIdx < column; colIdx++) {
                map[rowIdx][colIdx] = line.charAt(colIdx) - '0';
            }
        }

        // (0,0)에서 bfs 탐색
        int answer = bfs(new Pos(0, 0, 0));

        // 정답 출력
        System.out.println(answer);
    }

}