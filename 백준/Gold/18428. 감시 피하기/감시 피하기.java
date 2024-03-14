import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static List<int[]> teachers;
    static List<int[]> spaces;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean check() {
        for (int[] teacher : teachers) {
            for (int i = 0; i < 4; i++) {
                int nx = teacher[0];
                int ny = teacher[1];
                
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 'O') {
                        break;
                    }
                    if (map[nx][ny] == 'S') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean dfs(int count) {
        if (count == 3) {
            return check();
        }
        
        for (int[] space : spaces) {
            int x = space[0];
            int y = space[1];
            if (map[x][y] == 'X') {
                map[x][y] = 'O';
                if (dfs(count + 1)) {
                    return true;
                }
                map[x][y] = 'X';
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        teachers = new ArrayList<>();
        spaces = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j].charAt(0);
                if (map[i][j] == 'T') {
                    teachers.add(new int[]{i, j});
                } else if (map[i][j] == 'X') {
                    spaces.add(new int[]{i, j});
                }
            }
        }

        System.out.println(dfs(0) ? "YES" : "NO");
    }
}
