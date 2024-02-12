class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        answer = getResult(a, b);
        return answer;
    }
    
    static int getResult(int a, int b){
        String result1 = "";
        String result2 = "";
        
        result1 = Integer.toString(a) + Integer.toString(b);
        result2 = Integer.toString(b) + Integer.toString(a);
        
        int r1 = Integer.parseInt(result1);
        int r2 = Integer.parseInt(result2);
        
        System.out.println(r1 + ", " + r2);
        
        if(r1 >= r2){
            return r1;
        } else {
            return r2;
        }
    }
}