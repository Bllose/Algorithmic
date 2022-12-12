package bllose.arithmetic.theMinDouble;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    static {
        System.out. println (System.getProperty ("user.dir"));
        // System.setIn(SwitchSubString.class.getResourceAsStream("D:\\workplace\\github\\bllose-algorithmic\\src\\main\\java\\bllose\\arithmetic\\switchsubstring\\Letters.txt"));
        try {
            System.setIn(new FileInputStream("src\\main\\java\\bllose\\arithmetic\\theMinDouble\\source.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] nums = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        Arrays.sort(nums);

        int middle = 0;
        for(; middle < nums.length; middle ++){
            if(nums[middle] == 0){
                if(nums[middle + 1]  == 0){
                    System.out.println("0 0 0");
                    return;
                }
            }else if(nums[middle]> 0){
                break;
            }
        }

        int num1 = 0;
        int num2 = 0;
        int abs = Integer.MAX_VALUE;
        for(int fushu = middle - 1; fushu >= 0 ; fushu --){
            int lastResult = Integer.MAX_VALUE;
            for(int zhengshu = middle; zhengshu < nums.length; zhengshu ++ ){
                int temp = Math.abs(nums[fushu] + nums[zhengshu]);
                if(abs > temp){
                    num1 = nums[fushu];
                    num2 = nums[zhengshu];
                    abs = temp;
                    if(abs == 0){
                        System.out.println(num1 + " " + num2 + " " + abs);
                        return;
                    }
                    continue;
                }
                if(temp >= lastResult){
                    break;
                }else{
                    lastResult = temp;
                }
            }
        }
        System.out.println(num1 + " " + num2 + " " + abs);
    }
}
