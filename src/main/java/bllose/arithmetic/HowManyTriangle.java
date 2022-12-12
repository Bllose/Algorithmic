package bllose.arithmetic;

import java.util.Arrays;

/**
 * 给一个长度为N的非负整数数组 nums， 请你计算一下，
 * 有多少个三元组代表的边长可以组成三角形
 * 数据范围:
 * 1<= N <= 1000
 * 0<= nums[i] <= 1000
 */
public class HowManyTriangle {

    public int binarySearchSolution(int[] nums){
        Arrays.sort(nums);
        int ans = 0;
        for(int sideOne = 0; sideOne < nums.length - 2; sideOne ++){
            for(int sideTwo = sideOne + 1; sideTwo < nums.length - 1; sideTwo ++){
                int left = sideTwo + 1;
                int right = nums.length - 1;
                int threeSide = sideTwo;

                while(left <= right) {
                    int mid = (right + left) >> 1;
                    if (nums[mid] < nums[sideOne] + nums[sideTwo]) {
                        threeSide = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                ans += threeSide - sideTwo;

            }
        }
        return ans;
    }

    public int solution(int[] nums){
        int counter = 0;
        for(int left = 0; left < nums.length - 2; left ++){
            for(int middle = left + 1; middle < nums.length - 1; middle ++){
                for(int right = middle + 1; right < nums.length; right ++){
                    if(itCouldBeATriangle(nums[left], nums[middle], nums[right])){
                        counter ++;
                    }
                }
            }
        }
        return counter;
    }
    private boolean itCouldBeATriangle(int left, int middle, int right){
        return left + middle > right
                && left + right > middle
                && right + middle > left
                && right + left > middle
                && middle + left > right
                && middle + right > left;
    }


}
