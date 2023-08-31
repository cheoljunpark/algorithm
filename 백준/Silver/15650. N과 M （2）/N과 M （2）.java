import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 자연수(number)와 고를 개수(selectCount)를 입력받는다
 * 2. 크기가 number인 배열(numberList)를 생성한다
 * 3. numberList에 1부터 number까지 저장한다
 * 4. 크기가 number인 방문처리 배열(visited)를 생성한다
 * 5. 고른 것을 담을 배열(selectList)를 생성한다
 * 6. 조합 number_C_selectCount를 구해서 출력한다
 *    6.1 
 *
 */
public class Main {
	static int numberCount, selectCount;
	static int [] numberList;
	static int [] selectList;
	static boolean [] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static void combination(int numberIdx, int selectIdx) {
		// 기저 조건 1
		// selectCount개를 골랐다면 종료
		if(selectIdx == selectCount) {
			for(int selectNumber: selectList) {
				sb.append(selectNumber).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 기저 조건 2
		// 1부터 numberCount까지 확인했다면 종료
		if(numberIdx == numberCount) {
			return;
		}
		
		// 진행 로직
		
		// 원소 선택하고 넘어가기
		selectList[selectIdx] = numberList[numberIdx];
		combination(numberIdx+1, selectIdx+1);
		
		// 원소 선택하지 않고 넘어가기
		selectList[selectIdx] = 0;
		combination(numberIdx+1, selectIdx);
	}
	
	public static void main(String[] args) throws IOException{
		
		//	자연수(number)와 고를 개수(selectCount)를 입력받기
		st = new StringTokenizer(br.readLine().trim());
		numberCount = Integer.parseInt(st.nextToken());
		selectCount = Integer.parseInt(st.nextToken());
		
		// 크기가 number인 배열(numberList)를 생성한다
		numberList = new int[numberCount];
		
		// numberList에 1부터 number까지 저장
		for (int idx = 0; idx < numberList.length; idx++) {
			numberList[idx] = idx + 1;
		}
		
		
		// 고른 숫자를 담을 배열 생성
		selectList = new int[selectCount];
		
		// 조합 메소드 호출
		// number_C_selectCount 구하기
		combination(0, 0);
		
		// 정답 출력
		System.out.println(sb);
	}

}
