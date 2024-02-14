class Solution {
    public int solution(int[] num_list) {
        int sumSquare = 0; 
        int product = 1; 
        
        for(int n: num_list){
            sumSquare += n;
        }
        sumSquare *= sumSquare;
        
        
        for(int n: num_list){
            product *= n;
        }
        
        return sumSquare < product ? 0 : 1;
    }
}