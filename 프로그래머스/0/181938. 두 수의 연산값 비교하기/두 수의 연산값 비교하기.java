class Solution {
    public int solution(int a, int b) {
        int result1 = 0;
        int result2 = 0;
        
        String tmp = Integer.toString(a) + Integer.toString(b);
        
        result1 = Integer.parseInt(tmp);
        result2 = 2 * a * b;
        
        if(result1 > result2) {
            return result1;
        } else {
            return result2;
        }
    }
}