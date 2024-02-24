import java.util.Scanner;
import java.lang.StringBuilder;

public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        
        String a = sc.next();
        
        char[] arr = a.toCharArray();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]>='a' && arr[i]<='z'){
                sb.append((char)(arr[i] - 'a' + 'A'));
            } else {
                sb.append((char)(arr[i] - 'A' + 'a'));
            }
        }
        
        System.out.println(sb);
    }
}