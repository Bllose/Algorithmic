package bllose.arithmetic;

import java.util.Arrays;

public class ChafenSolution {

    /**
     * 1. 序列的前三分之一数据的中位数
     *
     * @param arr 无需队列
     * @return
     */
    public int getMedian(int[] arr){

        Arrays.sort(arr);

        int LEN = arr.length;
        int middleLen = (int) Math.ceil((double)LEN/3);

        if(middleLen % 2 == 1){
            return arr[middleLen/2];
        }else{
            return (int) Math.ceil((double)(arr[middleLen/2] + arr[middleLen/2-1])/2);
        }
    }
}
