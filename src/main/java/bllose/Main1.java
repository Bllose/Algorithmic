package bllose;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    static {
        try {
            System.setIn(new FileInputStream("src/main/java/bllose/source.txt"));
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
        int minV = Integer.valueOf(firstLine[1]);
        int maxV = Integer.valueOf(firstLine[2]);

        curLine = in.nextLine();
        String[] secondLine = curLine.split(" ");
        int[] values = Arrays.stream(secondLine).mapToInt(Integer::parseInt).toArray();

        if(totalNums == 1){
            System.out.println(values[0] + " " + values[0]);
            return;
        }

        solution(totalNums, minV, maxV, values);
    }

    private static void solution(int totalNums, int minV, int maxV, int[] values) {
        int left = 0;
        int right = 1;
        int[] min = new int[]{values[0], 0};
        int[] max = new int[]{values[1], 1};
        int gap = maxV - minV;
        int[] ans = new int[2];
        for(; right < totalNums; right ++){
            if(values[right] >= max[0] || values[right] <= min[0]){
                if(values[right] > min[0] && values[right] - min[0] <= gap){
                    max[0] = values[right];
                    max[1] = right;
                    continue;
                }else if(values[right] < max[0] && max[0] - values[right] <= gap){
                    min[0] = values[right];
                    min[1] = right;
                    continue;
                }else {
                    // 间隔已经超过最大值， 那么就可以记录当前子串了
                    int length = right - left - 1; // right当前位置不包含在子串中
                    if(length >= ans[1]) {
                        ans[0] = length;
                        int sum = 0;
                        for(int i = left; i < right; i++) {
                           sum += values[i];
                        }
                        if(length == ans[1] && sum > ans[0]){
                            ans[1] = sum;
                        }else if(length > ans[0]){
                            ans[1] = sum;
                        }
                    }

                    if(values[right] > max[1]) {
                        // 新增数字是最大值， 那么我们要记录该最大值，并且从最小值开始遍历，找到最新的最小值
                        max[0] = values[right];
                        max[1] = right;
                        left = min[1] + 1;
                        min[0] = values[left];
                        min[1] = left;
                        for (int i = left; i <= right; i++) {
                            // 寻找新的最小值
                            if(values[i] <= min[0]){
                                min[0] = values[i];
                                min[1] = i;
                            }
                        }
                    }else{
                        // 新增数字是最小值， 那么记录该最小值，并且从最大值开始遍历找到新的最大值
                        min[0] = values[right];
                        min[1] = right;
                        left = max[1] + 1;
                        max[0] = values[left];
                        max[1] = left;
                        for(int i = left; i <= right; i ++){
                            if(values[i] >= max[0]){
                                max[0] = values[i];
                                max[1] = i;
                            }
                        }
                    }
                }
            }else{
                continue;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
