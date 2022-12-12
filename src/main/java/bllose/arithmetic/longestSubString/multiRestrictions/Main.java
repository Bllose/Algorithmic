package bllose.arithmetic.longestSubString.multiRestrictions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static {
        try {
            System.setIn(new FileInputStream("src/main/java/bllose/arithmetic/longestSubString/multiRestrictions/source.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 给定一个长度为n的数组a，数组a的子串[i,j]表示a[i],a[i+1],a[i+2]……a[j]。
     * 求最大长度的子串，该子串必须满足：m1<=max(a[i],a[i+1]……a[j])-min(a[i],a[i+1]……a[j])<=m2。
     * 如果最大长度的子串有多个，请找出子串和最大的那个。
     * 对于子串[i,j]，子串和指的是Sum=a[i]+a[i+1]+a[i+2]+……a[j]，子串长度指的是length=j-i+1。
     * 如果没有子串满足，请输出“0 0”。
     *
     * 每个测试用例占两行，第一行为三个整数n,m1,m2。第二行为n个整数，从左到右依次为a[1],a[2]……a[n]。
     * 1<=n<=100000,0<=m1,m2,a[i]<=1000000。
     * 输出：子串长度 子串和
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String curLine = in.nextLine();
        String[] firstLine = curLine.split(" ");
        int totalNums = Integer.valueOf(firstLine[0]);
        int minEdge = Integer.valueOf(firstLine[1]);
        int maxEdge = Integer.valueOf(firstLine[2]);

        curLine = in.nextLine();
        String[] secondLine = curLine.split(" ");
        int[] values = Arrays.stream(secondLine).mapToInt(Integer::parseInt).toArray();

        if(totalNums == 1){
            System.out.println(values[0] + " " + values[0]);
            return;
        }

        solution(totalNums, minEdge, maxEdge, values);
    }


    static class subString implements Comparable<subString>{
        int[] nums;
        int minIndex = 0;
        int maxIndex = 0;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int left;
        int right;
        int sum = 0;
        int minEdge;
        int maxEdge;
        boolean hasNext = true;
        int length;

        subString(int[] values, int minEdge, int maxEdge, int left, int right){
            this.nums = values;
            this.minEdge = minEdge;
            this.maxEdge = maxEdge;
            this.left = left;
            this.right = right;
        }


        public subString next(){
            for(int i = right + 1; i < nums.length; i ++){
                if(nums[i] > maxValue){
                    // 当右侧新增值导致极值差超过限制， 那么下一个字串的起始点就出来了， 而当前子串也成型了
                    if(nums[i] - minValue > maxEdge || nums[i] - minValue < minEdge){
                        right = i - 1;
                        return new subString(nums, minEdge, maxEdge, minIndex + 1, i);
                    }else{
                        maxValue = nums[i];
                        maxIndex = i;
                    }
                }else if(nums[i] < minValue){
                    if(maxValue - nums[i] > maxEdge || maxValue - nums[i] < minEdge){
                        right = i - 1;
                        return new subString(nums, minEdge, maxEdge, maxIndex + 1, i);
                    }else{
                        minValue = nums[i];
                        minIndex = i;
                    }
                }

                if(nums[i] == maxValue){
                    maxIndex = i;
                }
                if(nums[i] == minValue){
                    minIndex = i;
                }
                sum += nums[i];
                length ++;
            }
            // 如果遍历完了， 说明当前已经是最后一个子串了
            hasNext = false;
            return null;
        }

        public void analyticalExtreme(){
            sum = 0;
            length = 0;
            for(int i = left; i <= right; i ++){
                sum += nums[i];
                length ++;
                if(nums[i] <= minValue){
                    minValue = nums[i];
                    minIndex = i;
                }
                if(nums[i] >= maxValue){
                    maxValue = nums[i];
                    maxIndex = i;
                }
            }
        }

        @Override
        public int compareTo(subString o) {
            // 降序排列； 当前长度 > 对比对象的长度， 那么 resultLen < 0  -> 比对对象排在后面
            //          当前和    > 对比对象的和,    那么 resultSum < 0  -> 比对对象排在后面
            int resultLen = o.length - this.length;
            if(resultLen != 0){
                return resultLen;
            }
            return  o.sum - this.sum;
        }
    }

    private static void solution(int totalNums, int minEdge, int maxEdge, int[] values) {
        subString init = new subString(values, minEdge, maxEdge,  0, 0);
        init.analyticalExtreme();

        List<subString> recorder = new ArrayList<>();
        subString temp = init;
        while(temp.hasNext){
            subString newSub = temp.next();
            recorder.add(temp);
            if(newSub != null) {
                temp = newSub;
                temp.analyticalExtreme();
            }
        }

        Collections.sort(recorder);
        System.out.println(recorder.get(0).length + " " + recorder.get(0).sum);
    }
}
