import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스를 입력받는다
 * 2. 각 테스트 케이스별로 날짜(date)를 입력받고 date를 쪼개 배열로 저장한다
 * 3. date[0], date[1], date[2], date[3]을 더한 값을 year에 저장
 *    date[4]와 date[5]를 더한 값을 month에 저장
 *    date[6]와 date[7]를 더한 값을 day에 저장
 * 4. month에 맞는 day가 맞으면 true, 아니면 false
 *    4.1 true라면 "year/month/day"로 출력
 *    4.2 false라면 -1 출력
 */
public class Solution {
    static int testCase;
    static String year, month, day;

    /**
     * 해당 월에 맞는 일인지 판단하는 메소드
     *
     * @return 일이 월에 맞는 숫자면  true,<br>
     * 일이 월에 맞지 않는 숫자면 false
     */
    static boolean isValid() {
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);
        int maxDayOfMonth = 0;

        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                maxDayOfMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxDayOfMonth = 30;
                break;
            case 2:
                maxDayOfMonth = 28;
                break;
        }

        if (d >= 1 && d <= maxDayOfMonth) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스를 입력받는다
        testCase = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스별로
        for (int tc = 1; tc <= testCase; tc++) {
            // 날짜(date)를 입력받고 date를 쪼개 배열로 저장한다
            String[] date = br.readLine().trim().split("");

            // (date[0], date[1], date[2], date[3])을 더한 값을 year에 저장
            year = date[0] + date[1] + date[2] + date[3];
            // (date[4], date[5])을 더한 값을 month에 저장
            month = date[4] + date[5];
            // (date[6], date[7])을 더한 값을 day에 저장
            day = date[6] + date[7];

            // 유효한지 판단하고 append
            if (isValid()) {
                sb.append("#").append(tc).append(" ").append(year).append("/").append(month).append("/").append(day).append("\n");
            } else {
                sb.append("#").append(tc).append(" ").append(-1).append("\n");
            }
        }
        // 정답 출력
        System.out.println(sb);
    }
}
