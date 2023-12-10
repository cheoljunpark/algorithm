import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 문자열을 입력받는다
 * 3. 문자열의 길이를 팔씨름을 한 횟수에 저장한다
 * 4. 문자열에서 "o"를 찾아 이긴 횟수에 저장한다
 * 5. 총 팔씨름 횟수 - 팔씨름을 한 횟수를 남은 팔씨름 횟수에 저장
 * 6. 이긴 횟수와 남은 팔씨름 수를 더한게 8이상이라면 "YES" 출력, 아니면 "NO" 출력
 */

public class Solution {

    static int findWin(String[] str){
        int win = 0;

        for (int idx = 0; idx < str.length; idx++) {
            if(str[idx].equals("o")){
                win++;
            }
        }

        return win;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 입력
        int testCase = Integer.parseInt(br.readLine().trim());


        // 각 테스트 케이스 별로
        for (int tc = 1; tc <= testCase; tc++) {

            // 문자역 입력받기
            String[] str = br.readLine().trim().split("");

            // 팔씨름 한 횟수
            int played = str.length;

            // 남은 팔씨름 횟수
            int remained = 15 - played;

            // 이긴 횟수
            int win = findWin(str);

            // 이긴 횟수와 남은 팔씨름 수를 더한게 8이상이라면 "YES" 출력, 아니면 "NO" 출력
            sb.append("#").append(tc).append(" ");
            if(win + remained >= 8){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }

        // 정답 출력
        System.out.println(sb);
    }
}



