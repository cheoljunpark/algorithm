import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 박철준
 *
 * 1. 영상의 크기(n)을 입력받는다
 * 2. nxn 크기의 배열을 만든다
 * 3. 배열에 0 또는 1을 입력받는다
 * 4. 합이 0(=모두 0이거나) 또는 nxn(=모두 1이거나)이 될 때까지 분할정복
 *    4.1 // 기저조건
 *        만약 합이 0이면
 *          0리턴, 
 *        만약 합이 1이면 
 *          1리턴,
 *    4.2 // 진행로직
 *        아니라면, 
 *          4분할  
 * 
 */
public class Main {
	static int n;
	static int[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	
	// 합이 0(=모두 0이거나) 또는 nxn(=모두 1이거나)이 될 때까지 분할정복
	// 만약 합이 0이면
	//   0리턴, 
	// 만약 합이 1이면 
	//   1리턴,
	// 아니라면, 
	//   4분할
	public static void divideAndConquer(int r, int c, int n) {
		// 합 구하기
		int sum=0;
		for (int rowIdx = r; rowIdx < r+n; rowIdx++) {
			for (int colIdx = c; colIdx < c+n; colIdx++) {
				sum += map[rowIdx][colIdx];
			}
		}
		
		if(sum==0) {
			sb.append(0);
		}else if(sum==n*n) {
			sb.append(1);
		}else {
			sb.append("(");
			divideAndConquer(r, c, n/2);
			divideAndConquer(r, c+n/2, n/2);
			divideAndConquer(r+n/2, c, n/2);
			divideAndConquer(r+n/2, c+n/2, n/2);
			sb.append(")");
		}
	}
	
	public static void main(String[] args) throws IOException{	
		// 영상의 크기(n) 입력받기
		n = Integer.parseInt(br.readLine().trim());
		
		// nxn 크기의 배열 만들기
		map = new int[n][n];
		
		// 배열에 0 또는 1 입력받기
		for (int rowIdx = 0; rowIdx < n; rowIdx++) {
			String[] str = br.readLine().trim().split("");
			for (int colIdx = 0; colIdx < n; colIdx++) {
				map[rowIdx][colIdx] = Integer.parseInt(str[colIdx]);
			}	
		}
		
		
		// 합이 0(=모두 0이거나) 또는 nxn(=모두 1이거나)이 될 때까지 분할정복
		// 만약 합이 0이면
		//   0리턴, 
		// 만약 합이 1이면 
		//   1리턴,
		// 아니라면, 
		//   4분할
		
		divideAndConquer(0,0,n);
		
		System.out.println(sb);
	}

}
