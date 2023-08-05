import java.util.Scanner;
 
/**
 * 
 * @author 박철준
 * 
 * 1. 테스트 케이스(T)를 입력 받는다
 * 2. 각 테스트 케이스마다 단어(word)를 입력받고
 * 3. 회문 검사하는 메소드를 호출한다
 * 4. 회문 검사 메소드에서는 처음과 끝 인덱스에서부터 각각 인덱스 증가, 감소를 하며
 * 5. 단어의 인덱스에 해당하는 문자가 같은지 확인
 * 6. (단어의 길이)/2 의 크기만큼 확인
 *
 */
 
public class Solution {
 
    static int palindrome(String word) {    // static으로 만들기
        for (int startIdx = 0, endIdx = word.length() - 1; startIdx < word.length() / 2; startIdx++, endIdx--) { // 처음 인덱스는 증가, 끝 인덱스는 감소하면서 검사
            if (word.charAt(startIdx) == word.charAt(endIdx)) {
                continue; // 단어가 대칭적이면 계속 검사
            } else {
                return 0; // 단어가 대칭적이지 않다면 0을 리턴
            }
        }
 
        return 1; // 단어가 모두 검사되고 회문이면 1을 리턴
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        sc.nextLine();
 
        for (int testCase = 0; testCase < T; testCase++) {
            String word = sc.nextLine();
 
            int result = palindrome(word);  // palindrome 메소드 호출해서 단어가 회문인지 검사
 
            System.out.printf("#%d %d%n", (testCase + 1), result);
        }
 
    }
 
}
