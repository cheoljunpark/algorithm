class Solution {
    static int getResultOdd(int n){
        int result = 0;
        
        for(int i = 1; i <= n; i += 2){
            result += i;
        }
        
        return result;
    }
    
    static int getResultEven(int n){
        int result = 0;
        
        for(int i=2; i <= n; i += 2){
            result += (int)Math.pow(i,2);
        }
        
        return result;
    }
    
    public int solution(int n) {
        int answer = 0;
        
        if(n % 2 == 1){
            answer = getResultOdd(n);
        } else {
            answer = getResultEven(n);
        }
        
        return answer;
    }
}