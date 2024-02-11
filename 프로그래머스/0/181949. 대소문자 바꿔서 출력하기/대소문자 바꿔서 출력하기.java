import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] arr = a.toCharArray();
        
        for(char str: arr){
            if(Character.isLowerCase(str)){
                sb.append(Character.toUpperCase(str));
            } else {
                sb.append(Character.toLowerCase(str));
            }
        }
        
        System.out.println(sb);
    }
}