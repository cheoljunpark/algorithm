import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] str = a.toCharArray();
        
        for(char ch : str) {
            System.out.println(ch);
        }
    }
}