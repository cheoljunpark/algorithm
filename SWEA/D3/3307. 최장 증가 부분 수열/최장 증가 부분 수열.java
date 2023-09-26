import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스 별로 수열의 길이를 입력받는다
 * 3. 입력받은 길이의 크기만큼 배열을 생성한다
 * 4. 이진 검색으로 LIS를 구한다
 *
 */

public class Solution {
	static int testCase;
	static int[] arr;
	static int arrSize;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int binarySearchLis(int[] arr) { // 이진 검색으로 LIS 구하는 메소드

		List<Integer> list = new ArrayList<>();

		list.add(arr[0]); // 첫 번째 수 넣기

		for (int idx = 0; idx < arr.length; idx++) {
			if (arr[idx] > list.get(list.size() - 1)) { // 맨 뒤 수보다 더 큰 수라면 이진 탐색 하지 않고 마지막에 추가
				list.add(arr[idx]);
			} else {
				binarySearch(list, arr[idx]);
			}
		}

		return list.size();
	}

	static void binarySearch(List<Integer> list, int target) {

		int start = 0;
		int end = list.size() - 1;

		while (start <= end) { // 처음부터 끝까지 탐색
			int mid = start + ((end - start) >>> 1);

			if (list.get(mid) == target) { // 중간값이 더 크다면 범위 작게 바꾸기
				return;
			}

			if (list.get(mid) > target) { // 중간값이 더 작다면 범위 크게 바꾸기
				end = mid - 1;
			}

			if (list.get(mid) < target) {
				start = mid + 1;
			}
		}

		list.set(start, target); // 순서에 맞게 리스트에 세팅

	}

	public static void main(String[] args) throws IOException {

		// 테스트 케이스 입력받기
		testCase = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= testCase; tc++) {

			// 수열의 길이 입력받기
			arrSize = Integer.parseInt(br.readLine().trim());

			// 수열 생성
			arr = new int[arrSize];

			// 수열 입력받기
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < arrSize; idx++) {
				arr[idx] = Integer.parseInt(st.nextToken());
			}

			// 이진 검색으로 LIS 구하기
			int lis = binarySearchLis(arr);

			// LIS append
			sb.append("#").append(tc).append(" ").append(lis).append("\n");
		}

		// 출력
		System.out.println(sb);
	}

}
