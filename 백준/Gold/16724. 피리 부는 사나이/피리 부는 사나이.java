import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int safeZone;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] finished;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        finished = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < M; j++) {
                char dir = line.charAt(j);
                if (dir == 'U') {
                    map[i][j] = 0;
                } else if (dir == 'D') {
                    map[i][j] = 1;
                } else if (dir == 'L') {
                    map[i][j] = 2;
                } else if (dir == 'R') {
                    map[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(safeZone);
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;

        int nr = r + dx[map[r][c]];
        int nc = c + dy[map[r][c]];

        if (!visited[nr][nc]) {
            dfs(nr, nc);
        } else {
            if (!finished[nr][nc]) {
                safeZone++;
            }
        }

        finished[r][c] = true;
    }
}
