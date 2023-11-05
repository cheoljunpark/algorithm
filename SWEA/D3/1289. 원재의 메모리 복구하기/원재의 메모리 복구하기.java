import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 숫자를 입력받아 리스트(originNumList)에 넣는다
 * 3. originNumList의 크기만큼 리스트(numList)를 생성한다
 * 4. originNumList의 각 인덱스를 순회하면서 값이 같으면 패스하고
 *    값이 다르면 해당 값으로 numList의 인덱스부터 끝가지 해당 값으로 변경
 * 5.
 */
public class Solution {
    static int testCase;
    static int[] originNumList, numList;
    static int changeCnt;

    /**
     * 원래 메모리값과 변경된 메모리값이 같은지 확인하는 메소드
     *
     * @return 같으면 true,<br> 다르면 false
     */
    static boolean isEqual() {
        for (int idx = 0; idx < originNumList.length; idx++) {
            if (originNumList[idx] != numList[idx]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 입력받은 인덱스부터 끝 인덱스까지 <br>
     * 메모리값을 바꾸는 메소드
     *
     * @param idx       바꾸기 사작할 인덱스
     * @param originNum 해당 인덱스의 원래 메모리 값
     */
    static void change(int idx, int originNum) {
        for (int i = idx; i < numList.length; i++) {
            numList[i] = originNum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 입력
        testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스별로
        for (int tc = 1; tc <= testCase; tc++) {

            // 원래 메모리 값 리스트 생성
            String[] str = br.readLine().trim().split("");
            originNumList = new int[str.length];
            for (int idx = 0; idx < str.length; idx++) {
                originNumList[idx] = Integer.parseInt(str[idx]);
            }

            // 초기화 된 메모리 리스트 생성
            numList = new int[originNumList.length];

            // 바꾼 횟수 초기화
            changeCnt = 0;

            // 각 인덱스 비교
            for (int idx = 0; idx < originNumList.length; idx++) {
                if (isEqual()) {    // 원래 메모리와 초기화 되었던 메모리가 같아졌다면
                    break;
                }
                if (originNumList[idx] != numList[idx]) {   // 해당 인덱스의 원래 메모리값과 초기화 되었던 메모리값이 다르다면
                    change(idx, originNumList[idx]);    // 해당 인덱스부터 끝 인덱스까지 원래 메모리값으로 바꾸기
                    changeCnt++;    // 바꾼 횟수 증가
                }
            }

            // 바꾼 횟수 append
            sb.append("#").append(tc).append(" ").append(changeCnt).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}
