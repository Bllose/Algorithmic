package bllose.sortrelated;

public class SearchRange {

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     *
     * 16:16	info
	 *		解答成功:
	 *		执行耗时:0 ms,击败了100.00% 的Java用户
	 *		内存消耗:43.9 MB,击败了99.73% 的Java用户
     *  
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target){
        if(null == nums || nums.length == 0) return new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        int middle = (right - left) >> 1;
        int[] result = {-1, -1};

        while(left <= right){
            if(nums[middle] == target){
                if(left==right){
                    return new int[]{left, right};
                }
                result[0] = middle - 1;
                while(result[0] > -1 && nums[result[0]] == target){
                    result[0] -= 1;
                }
                result[0] += 1;

                result[1] = middle + 1;
                while(result[1] < nums.length && nums[result[1]] == target){
                    result[1] += 1;
                }
                result[1] -= 1;
                break;
            } else {
                if(nums[middle] > target){
                    if(right == middle){
                        right --;
                        middle --;
                    }else {
                        right = middle;
                        middle = left + (right - left) >> 1;
                    }
                }else{
                    if(left == middle){
                        left ++;
                        middle ++;
                    }else{
                        left = middle;
                        middle = left + (right - left) >> 2;
                    }
                }
            }
        }

        return result;
    }
}
