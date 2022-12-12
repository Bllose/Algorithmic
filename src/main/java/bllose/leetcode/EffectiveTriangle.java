package bllose.leetcode;

import java.util.Arrays;

public class EffectiveTriangle {
    /**
     执行耗时:374 ms,击败了20.22% 的Java用户
     内存消耗:41.3 MB,击败了8.09% 的Java用户
     *
     * @param nums
     * @return
     */
    public static int triangleNumber(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int counter = 0;
        int lenAmount = nums.length;
        for(int edge1 = 0; edge1 < lenAmount - 2; edge1 ++){
            if(nums[edge1] == 0){
                continue;
            }
            for(int edge2 = edge1 + 1; edge2 < lenAmount - 1; edge2 ++){
                int twoEdgeLen = nums[edge1] + nums[edge2];
                int index = edge2 + (lenAmount - edge2)/2;
                while(index < lenAmount - 1 && nums[index] < twoEdgeLen){
                    index += (lenAmount-index)/2;
                }
                while(nums[index] >= twoEdgeLen && index > edge2){
                    index --;
                }
                if(nums[index] < twoEdgeLen){
                    counter += index - edge2;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        System.out.println("4 = " + triangleNumber(new int[]{4,2,3,4}));

    }
}
