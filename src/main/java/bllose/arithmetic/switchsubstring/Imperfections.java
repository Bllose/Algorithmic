package bllose.arithmetic.switchsubstring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 【最长的指定瑕疵度的元音子串】
 * 开头和结尾都是元音字母（aeiouAEIOU）的字符串为 元音字符串 ，其中混杂的非元音字母数量为其 瑕疵度 。比如:
 * · “a” 、 “aa”是元音字符串，其瑕疵度都为0
 * · “aiur”不是元音字符串（结尾不是元音字符）
 * · “abira”是元音字符串，其瑕疵度为2
 * 给定一个字符串，请找出指定瑕疵度的最长元音字符子串，并输出其长度，如果找不到满足条件的元音字符子串，输出0。
 * 子串：字符串中任意个连续的字符组成的子序列称为该字符串的子串。
 * 输入描述：
 * 首行输入是一个整数，表示预期的瑕疵度flaw，取值范围[0, 65535]。
 * 接下来一行是一个仅由字符a-z和A-Z组成的字符串，字符串长度(0, 65535]。
 * 输出描述：
 * 输出为一个整数，代表满足条件的元音字符子串的长度。
 * 示例1：
 * 输入
 * 0
 * asdbuiodevauufgh
 * 输出
 * 3
 */
public class Imperfections {
    static{
        try {
            System.setIn(new FileInputStream("src\\main\\java\\bllose\\arithmetic\\switchsubstring\\Imperfections.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Character> vowels = new ArrayList<Character>(){{
            add('a');add('e');add('i');add('o');add('u');
            add('A');add('E');add('I');add('O');add('U');
        }};
        Scanner in = new Scanner(System.in);
        int specificImper = in.nextInt();
        in.nextLine();
        String ori = in.nextLine();
        char[] origin = ori.toCharArray();

        int imperfection = 0;
        int left = 0;
        int right = left + 1;
        int ans = 0;
        for( ; left < origin.length; left ++){
            if(vowels.contains(origin[left])){ // 起点开始
                if(ans == 0){
                    ans = 1;
                }
                for(; right < origin.length ; right ++){
                    if(!vowels.contains(origin[right])){
                        imperfection ++;
                    }else if(imperfection < specificImper){
                        continue;
                    }else if(imperfection == specificImper){
                        ans = right - left + 1 > ans ? right - left + 1 : ans;
                    }else{
                        break;
                    }
                }
            }else{
                if(imperfection > 0) {
                    imperfection--;
                }
            }
        }
        System.out.println(ans);
    }
}
