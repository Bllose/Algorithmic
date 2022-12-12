package bllose.arithmetic;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目
 */
public class SubArrayDivByK {

    public static int subarraysDivByK(int[] nums, int K) {
        int ans = 0;
        for(int len = 0; len < nums.length; len ++){
            int recorder = 0;
            for(int start = 0 ; start + len < nums.length; start ++){
                int end = start + len;
                if(recorder == 0 && start == 0) {
                    for (int i = start; i <= end; i++) {
                        recorder += nums[i];
                    }
                }else{
                    recorder -= nums[start - 1];
                    recorder += nums[end];
                }
                if(recorder%K == 0) ans ++;
            }
        }
        return ans;
    }
}
