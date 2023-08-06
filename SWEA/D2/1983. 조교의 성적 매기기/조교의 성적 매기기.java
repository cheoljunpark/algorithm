import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 학생수(n)과 학점을 알고싶은 학생의 번호(k)를 입력받는다
 * 3. 총 n명의 학생의 중간 기말 과제를 입력받아
 * 4. 총점을 계산해 총점을 저장할 배열에 저장한다
 * 5. 총점 배열을 내림차순으로 계산한다
 * 6. 10개의 평점이 있는 배열을 선언 및 정의한다
 * 7. 총점 배열에서 n/10명의 인덱스를 지날때마다 평점배열의 인덱스를 증가시킨다
 * 8. 총점배열에서 학생 번호 k의 인덱스를 지날때의 평점을 구한다 
 * 
 */

public class Solution {

	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());

		// 테스트 케이스 별로
		for (int tc = 0; tc < testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken()); // 학생 수(n) 입력받기
			int k = Integer.parseInt(st.nextToken()); // 학점을 알고싶은 학생의 번호(k)
			double totalK = 0; // 번호 k 학생의 총점
			int idxK = 0; // 정렬된 후 번호 k 학생의 인덱스

			// n명의 총점을 저장할 배열
			// 내림차순 정렬할때 primitive type은 적용안돼서 wrapper 클래스 사용
			Double[] total = new Double[n];

			// n명의 학생의 중간, 기말, 과제 입력받아서 총점계산해서 저장
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int midTerm = Integer.parseInt(st.nextToken());
				int finalTerm = Integer.parseInt(st.nextToken());
				int assignment = Integer.parseInt(st.nextToken());

				total[i] = (midTerm * 0.35) + (finalTerm * 0.45) + (assignment * 0.2);
				if (i + 1 == k) { // 번호 k 학생이라면
					totalK = total[i]; // 정렬된 후 인덱스를 찾게 총점 저장
				}
			}

			// 총점 배열 내림차순으로 계산
			Arrays.sort(total, Collections.reverseOrder());

			// 내림차순 후 번호 k 학생의 점수의 인덱스
			for (int idx = 0; idx < total.length; idx++) {
				if (total[idx] == totalK) { // 총점이 번호 k 학생의 총점과 같다면
					idxK = idx; // 인덱스를 저장
					break;
				}
			}

			// 10개의 평점이 있는 배열을 선언 및 정의한다
			String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

			// 총점 배열에서 n/10명의 인덱스를 지날때마다 평점배열의 인덱스를 증가시킨다
			// 총점배열에서 번호 k 학생의 인덱스를 지날때의 평점을 구한다
			int gradeIdx = 0; // 평점배열의 인덱스
			for (int idx = 1; idx <= n; idx++) {
				if (idx % (n / 10) == 0) {
					gradeIdx++;
				}
				if (idx == idxK)	// 학생 번호 k의 인덱스와 같다면
					break;
			}

			sb.append("#").append(tc + 1).append(" ").append(grade[gradeIdx]).append("\n");
		}

		System.out.println(sb);
	}

}
