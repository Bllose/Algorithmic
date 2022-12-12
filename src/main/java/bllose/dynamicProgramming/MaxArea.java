package bllose.dynamicProgramming;

public class MaxArea {

    public int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int area = Math.min(height[left], height[right]) * (right - left);
        while(left < right){
            if(height[left] > height[right]){
                right --;
                int newArea = Math.min(height[left], height[right]) * (right - left);
                if(newArea > area){
                    area = newArea;
                }
            }else{
                left ++;
                int newArea = Math.min(height[left], height[right]) * (right - left);
                if(newArea > area){
                    area = newArea;
                }
            }
        }
        return area;
    }
}
