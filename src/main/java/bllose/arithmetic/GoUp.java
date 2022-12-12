package bllose.arithmetic;

import java.util.Arrays;

public class GoUp {
    
    /**
     * 暴力破解， O(n * 2^n)
     * 
     * @param nums
     * @param begin
     * @return
     */
    private static int bruteForce(int[] nums, int begin){
        if(begin == nums.length - 1) return 1;

        int maxLen = 1;
        for(int curIndex = begin + 1; curIndex < nums.length; curIndex ++){
            if(nums[curIndex] > nums[begin]) {
                maxLen = Math.max(maxLen, bruteForce(nums, curIndex) + 1) ;
            }
        }
        return maxLen;
    }
    public static int longestSubArray(int[] nums){
        int longest = 0;
        for( int i = 0; i <  nums.length; i ++){
            longest = Math.max(longest, bruteForce(nums, i));
        }
        return longest;
    }


    /**
     * 
     * @param nums
     * @param begin
     * @param memo
     * @return
     */
    private static int memory(int[] nums, int begin, int[] memo){
        if(memo[begin] != 0) return memo[begin];

        if(begin == nums.length - 1) return 1;

        int maxLen = 1;
        for(int curIndex = begin + 1; curIndex < nums.length; curIndex ++){
            if(nums[curIndex] > nums[begin]) {
                maxLen = Math.max(maxLen, memory(nums, curIndex, memo) + 1) ;
            }
        }

        memo[begin] = maxLen;
        return maxLen;
    }
    public static int longestSubArrayByMemo(int[] nums){
        int longest = 0;
        int[] memo = new int[nums.length];
        for( int i = 0; i <  nums.length; i ++){
            longest = Math.max(longest, memory(nums, i, memo));
        }
        return longest;
    }


    /**
     * 动态规划，非递归，迭代
     * 
     * @param nums
     * @return
     */
    public static int Nonrecursive(int[] nums){
        int[] recorder = new int[nums.length];
        Arrays.fill(recorder, 1);

        for(int begin = nums.length - 1; begin >= 0; begin --){
            for(int curIndex = begin; curIndex < nums.length; curIndex ++){
                if(nums[curIndex] > nums[begin]){
                    recorder[begin] = Math.max(recorder[begin], recorder[curIndex] + 1);
                }
            }
        }

        return Arrays.stream(recorder).max().getAsInt();
    }

    private static int[] array = new int []{
        614,812,508,165,266,945,202,444,587,708,459,541,183,359,699,274,318,576,744,289,478,102,895,8,158,894,481,271,107,993,567,455,875,815,838,598,819,795,446,707,379,747,339,233,58,149,884,448,893,225,863,984,520,916,340,600,399,88,85,908,572,896,396,56,681,801,936,362,978,334,208,314,186,609,390,404,488,25,938,524,751,468,680,874,995,923,935,429,180,817,689,753,501,72,357,94,977,432,545,70
    };
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(longestSubArray(array));
        System.out.println("耗时" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(longestSubArrayByMemo(array));
        System.out.println("耗时" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(Nonrecursive(array));
        System.out.println("耗时" + (System.currentTimeMillis() - start));
    }

}
