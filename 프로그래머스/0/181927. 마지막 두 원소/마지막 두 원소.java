import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        
        int a = num_list[num_list.length - 2];
        int b = num_list[num_list.length - 1];
        int c = 0;
        
        if(b > a) {
            c = b - a;    
        } else {
            c = b * 2;
        }
        
        for(int i = 0; i < num_list.length; i++){
            answer[i] = num_list[i];
        }
        answer[num_list.length] = c;
        
        return answer;
    }
}