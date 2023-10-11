import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 맵의 크기를 입력받는다
 * 2. 맵을 생성한다
 * 3. 맵을 입력받는다
 *    3.1 "9"를 입력받았을 때 상어 위치 저장
 * 4. 상어의 위치에서 BFS 탐색
 *
 */

public class Main {
	static int mapSize;
	static int[][] map;
	static boolean[][] visited;
	static BabyShark babyShark;
	static int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static final int SHARK = 9;
	static final int SPACE = 0;
	static BufferedReader br;
	static StringTokenizer st;

	static class BabyShark{
		int x, y, size, eaten;

		public BabyShark(int x, int y, int size, int eaten) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.eaten = eaten;
		}
	}
	
	static class Fish implements Comparable<Fish>{
		int x, y, size,dist;
		
		Fish(int x, int y, int size, int dist){
			this.x = x;
			this.y = y;
			this.size = size;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.dist == o.dist) {
				if(this.x == o.x) {
					return this.y - o.y;
				}
				return this.x - o.x;
			}
			return this.dist - o.dist;
		}
	}

	static Fish getPrey() {
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		visited = new boolean[mapSize][mapSize];
		pq.offer(new Fish(babyShark.x, babyShark.y, 0, 0));
		visited[babyShark.x][babyShark.y] = true;
		Fish prey = null;
		while(!pq.isEmpty()) {
			Fish now = pq.poll();
			if(map[now.x][now.y]!= SPACE && map[now.x][now.y]!=SHARK) {
				if(map[now.x][now.y] < babyShark.size) {
					prey = now;
					break;
				} else if(map[now.x][now.y] > babyShark.size) {
					continue;
				}
			}
			
			for(int[] dir:DIR) {
				int nx = now.x +dir[0];
				int ny = now.y +dir[1];
				if(nx<0||nx>=mapSize||ny<0||ny>=mapSize||visited[nx][ny]||map[nx][ny]>babyShark.size) {
					continue;
				}
				visited[nx][ny] = true;
				pq.offer(new Fish(nx,ny, map[nx][ny], now.dist+1));
			}
		}
		
		return prey;
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		// 맵의 크기를 입력받는다
		mapSize = Integer.parseInt(br.readLine().trim());

		// 맵을 생성한다
		map = new int[mapSize][mapSize];

		// 맵을 입력받는다
		for (int rowIdx = 0; rowIdx < mapSize; rowIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int colIdx = 0; colIdx < mapSize; colIdx++) {
				map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				if (map[rowIdx][colIdx] == SHARK) { // 아기 상어라면
					babyShark = new BabyShark(rowIdx, colIdx, 2, 0); // 아기 상어 위치 저장
				}
			}
		}

		int time = 0;
		while(true) {
			Fish prey = getPrey();
			
			// 먹이가 없다면
			if(prey == null) {
				break;
			}
			
			// 먹이가 있다면
			babyShark.eaten++;	// 먹은 개수 증가
			map[babyShark.x][babyShark.y] = SPACE;
			if(babyShark.eaten == babyShark.size) {
				babyShark = new BabyShark(prey.x, prey.y, babyShark.size+1, 0);
			} else {
				babyShark = new BabyShark(prey.x, prey.y, babyShark.size, babyShark.eaten);
			}
			map[babyShark.x][babyShark.y] = SHARK;
			time += prey.dist;
		}
		
		System.out.println(time);
	}

}
