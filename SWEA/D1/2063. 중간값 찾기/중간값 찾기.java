import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. 리스트의 길이(numCnt)를 입력받는다
 * 2. 리스트(numList)를 입력받는다
 * 3. numList를 오름차순 정렬한다
 * 4. numList[numCnt/2]를 출력
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 리스트의 길이(numCnt)를 입력받는다
        int numCnt = Integer.parseInt(br.readLine().trim());

        // 리스트(numList) 생성
        int[] numList = new int[numCnt];

        // 리스트(numList)를 입력받는다
        st = new StringTokenizer(br.readLine().trim());
        for (int idx = 0; idx < numCnt; idx++) {
            numList[idx] = Integer.parseInt(st.nextToken());
        }

        // numList 오름차순 정렬
        Arrays.sort(numList);

        // numList[numCnt/2]를 출력
        System.out.println(numList[numCnt / 2]);
    }
}
