class Solution {
    public int solution(int[] num_list) {
        int length = num_list.length;
        
        if(length >= 11) {
            return getSum(num_list);
        } else {
            return getMultiply(num_list);
        }
    }
    
    public int getSum(int[] num_list) {
        int result = 0;
        
        for(int n: num_list){
            result += n;
        }
        
        return result;
    }
    
    public int getMultiply(int[] num_list) {
        int result = 1;
        
        for(int n: num_list){
            result *= n;
        }
        
        return result;
    }
}