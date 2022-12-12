package bllose.arithmetic.theMin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 求字符串中所有整数的最小和
 *
 * 输入字符串s，输出s中包含所有整数的最小和
 * 说明
 * 1. 字符串s，只包含 a-z A-Z +- ；
 * 2. 合法的整数包括
 * 1）正整数 一个或者多个0-9组成，如 0 2 3 002 102
 * 2）负整数 负号 - 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
 * 输入描述：
 * 包含数字的字符串
 * 输出描述：
 * 所有整数的最小和
 * 示例1：
 * 输入
 * bb1234aa
 * 输出
 * 10
 */
public class TheMinSum {
    static {
        try {
            System.setIn(new FileInputStream("src\\main\\java\\bllose\\arithmetic\\theMin\\source1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        int sum = 0;
        List<Character> nums = new ArrayList<Character>(){{
            add('0');
            add('1');
            add('2');
            add('3');
            add('4');
            add('5');
            add('6');
            add('7');
            add('8');
            add('9');
        }};

        char[] origin = input.toCharArray();
        for(int i = 0 ; i < origin.length; i++){
            char cur = origin[i];
            if(cur == '-'){
                StringBuffer negative = new StringBuffer();
                negative.append('-');
                i++;
                while(i < origin.length && nums.contains(origin[i])){
                    negative.append(origin[i]);
                    i++;
                }
                if(negative.length() > 1){
                    sum += Integer.valueOf(negative.toString());
                }
                if(i == origin.length){
                    break;
                }
            }
            if(origin[i] == '0'){
                continue;
            }else if(nums.contains(origin[i])){
                sum += Integer.valueOf(String.valueOf(origin[i]));
            }
        }

        System.out.println(sum);
    }
}
