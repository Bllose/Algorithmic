package bllose.arithmetic.theMin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    static {
        System.out. println (System.getProperty ("user.dir"));
        // System.setIn(SwitchSubString.class.getResourceAsStream("D:\\workplace\\github\\bllose-algorithmic\\src\\main\\java\\bllose\\arithmetic\\switchsubstring\\Letters.txt"));
        try {
            System.setIn(new FileInputStream("src\\main\\java\\bllose\\arithmetic\\theMin\\source.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arry = in.nextLine().split(" ");
        Integer[] nums = Stream.of(arry).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        int up = 0;
        int down = 0;
        for(int i = 0 ; i < nums.length; i ++){
            if(nums[i] < 0) continue;
            up = i;
            down = i - 1;
            break;
        }


        int jdz = Integer.MAX_VALUE;

        int zhengshu = nums.length - up;
        int fushu = down + 1;
        if(zhengshu >= fushu){ // 负数数量小于
            int[][] recorder = new int[fushu][zhengshu];
            for(int row = down; row >= 0 ; row ++){
                for(int column = up ; column < nums.length; column ++){
                    int result= Math.abs(nums[down] + nums[up]);
                    if(column == up){
                        recorder[row - down][0] = result;
                    }else{
                        if(result > recorder[down-row][column-up-1]) {
                            if(jdz > result) jdz = result;
                            break;
                        } else{
                            recorder[down - row][column - up] = result;
                        }
                    }

                }
            }
        }else{
            int[][] recorder = new int[zhengshu][fushu];
            for(int row = up; row < nums.length; row ++){
                for(int column = down; down >= 0; column --){
                    int result= Math.abs(nums[down] + nums[up]);
                    if(column == down){
                        recorder[row - up][0] = result;
                    }else{
                        if(result > recorder[row - up][down - column - 1]){
                            if(jdz > result) jdz = result;
                            break;
                        }else{
                            recorder[row - up][down - column] = result;
                        }
                    }
                }
            }
        }

        System.out.println(jdz);
    }
}
