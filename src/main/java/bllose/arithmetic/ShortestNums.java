package bllose.arithmetic;

public class ShortestNums {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 517ms 16716KB
     * 199ms 16908KB
     * 134ms 17076KB
     * 
     * @param nums int整型一维数组 
     * @param target int整型 
     * @return int整型
     */
    public int minSubarray (int[] nums, int target) {
        int ans = 99999;
        int counter = nums[0];
        int right = 1;
        for(int left = 0; right < nums.length;){
            if(nums[left] >= target) return 1;
            for(; right < nums.length ; right ++){
                counter += nums[right];
                if (counter < target){ 
                    continue;
                }else {
                    /**
                     * 统计长度
                     * 左侧收缩，再次比较是否满足条件。若满足则继续统计并收缩，直到 counter < target
                     */
                    while(right < nums.length && counter >= target){
                        if(ans > right - left + 1) ans = right - left + 1;
                        counter -= nums[left]; 
                        left ++;
                    }
                    right ++; // 统计完成后，准备下一轮统计， 右侧向前一步，准备加入新的counter中
                    break;
                }
            } 
        }
        return ans;
    }

    /**
     * 119ms 16820KB
     * 
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target){
        int minLen = nums.length;
        int left = 0;
        int right = 0;
        int counter = 0;
        while(right < nums.length){
            if(nums[right] >= target) return 1;
            counter += nums[right ++];
            while(left <= right && counter >= target){
                counter -= nums[left ++];
                minLen = java.lang.Math.min(minLen, right - left + 1);
            }
        }
        return minLen;
    }
}