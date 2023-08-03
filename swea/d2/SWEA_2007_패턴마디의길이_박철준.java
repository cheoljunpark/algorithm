import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
 
/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 문자열을 입력받는다
 * 3. 인덱스를 돌면서 substring 메소드를 사용해
 * 4. 0 ~ idx-1까지의 문자열과 idx ~ idx*2-1까지의 문자열이 같은지 확인
 */
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        StringBuilder sb = new StringBuilder(); // 출력
         
        // 테스트 케이스 개수 입력받기
        int testCase = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 0; tc < testCase; tc++) {
            String str = br.readLine().trim();  // 문자열 입력받기
 
            sb.append("#").append(tc + 1).append(" ");
            for (int idx = 1; idx < str.length(); idx++) {
                // 0 ~ idx-1까지의 문자열과 idx ~ idx*2-1까지의 문자열이 같다면
                // 해당 idx를 출력
                if (str.substring(0, idx).equals(str.substring(idx, idx * 2))) { 
                    sb.append(idx).append("\n");
                    break;
                }
            }
        }
 
        System.out.println(sb);
    }
 
}
