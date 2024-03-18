import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] map, nutrition;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static Queue<Tree> treeList = new PriorityQueue<>();
    static Queue<Tree> deadTreeList = new ArrayDeque<>();

    static class Tree implements Comparable<Tree> {
        int x, y;
        int age;

        Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        // 맵크기, 나무개수, 연도 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 맵과 nutrition 생성
        map = new int[N + 1][N + 1];
        nutrition = new int[N + 1][N + 1];

        // 맵 전체에 양분 5 생성
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], 5);
        }

        // nutrition 입력받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= N; j++) {
                nutrition[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // M(나무개수)만큼 나무 받아서 심기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            treeList.offer(new Tree(x, y, age));
        }

        for (int year = 0; year < K; year++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(treeList.size());
    }

    static void spring() {
        Queue<Tree> tmpList = new PriorityQueue<>();

        while (!treeList.isEmpty()) {
            Tree tree = treeList.poll();
            int x = tree.x;
            int y = tree.y;
            int age = tree.age;

            if (map[x][y] < age) {
                deadTreeList.offer(tree);
            } else {
                map[x][y] -= age;
                tree.age++;
                tmpList.offer(tree);
            }

        }

        treeList = tmpList;
    }

    static void summer() {
        while (!deadTreeList.isEmpty()) {
            Tree tree = deadTreeList.poll();
            int x = tree.x;
            int y = tree.y;
            int age = tree.age;

            map[x][y] += age / 2;
        }
    }

    static void fall() {
        Queue<Tree> tmpList = new PriorityQueue<>();

        while (!treeList.isEmpty()) {
            Tree tree = treeList.poll();
            int x = tree.x;
            int y = tree.y;
            int age = tree.age;
            tmpList.offer(tree);

            if (age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (1 <= nx && nx <= N && 1 <= ny && ny <= N) {
                        tmpList.offer(new Tree(nx, ny, 1));
                    }
                }
            }
        }

        treeList = tmpList;
    }

    static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += nutrition[i][j];
            }
        }
    }
}
