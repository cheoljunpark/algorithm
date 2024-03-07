import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr, int[] query) {
        int start = 0;
        int end = arr.length;

        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) { 
                end = Math.min(end, start + query[i] + 1);
            } else { 
                start += query[i];
                if(start >= end) {
                    return new int[]{};
                }
            }
        }

        return Arrays.copyOfRange(arr, start, end);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};
        int[] result = solution.solution(arr, query);
        System.out.println(Arrays.toString(result));
    }
}
