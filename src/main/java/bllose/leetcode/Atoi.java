package bllose.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atoi {

    /**
     * 			执行耗时:3 ms,击败了11.31% 的Java用户
     * 			内存消耗:41 MB,击败了90.72% 的Java用户
     *
     * @param s
     * @return
     */
    public static int myAtoiLong(String s){
        s = s.trim();

        boolean isMinus = false;
        if(s.startsWith("-")){
            isMinus = true;
            s = s.substring(1);
        }else if(s.startsWith("+")){
            s = s.substring(1);
        }

        if(s.length() == 0){
            return 0;
        }

        List<Character> nums = new ArrayList<Character>(){{
            add('0'); add('1'); add('2'); add('3'); add('4');
            add('5'); add('6'); add('7'); add('8'); add('9');
        }};
        char[] original = s.toCharArray();
        if(!nums.contains(original[0])){
            return 0;
        }

        for(int i = 0 ; i < original.length; i ++){
            if(original[i] != '0'){
                original = Arrays.copyOfRange(original, i, original.length);
                break;
            }
        }

        long ans = 0l;
        for(int i = 0 ; i < 11 && i < original.length; i ++){
            if(nums.contains(original[i])){
                ans = ans * 10 + Integer.valueOf(String.valueOf(original[i]));
            }else{
                break;
            }
        }

        if(isMinus){
            ans = - ans;
            if(ans <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }else{
            if(ans >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }

        return Math.toIntExact(ans);
    }

    /**
     * 			执行耗时:9 ms,击败了5.12% 的Java用户
     * 			内存消耗:41.5 MB,击败了26.28% 的Java用户
     *
     * @param s
     * @return
     */
    public static int myAtoiLongWithRegex(String s){
        s = s.trim();

        boolean isMinus = false;
        if(s.startsWith("-")){
            isMinus = true;
            s = s.substring(1);
        }else if(s.startsWith("+")){
            s = s.substring(1);
        }

        if(!Pattern.compile("^[0-9]").matcher(s).find()){
            return 0;
        }else{
            while(s.startsWith("0")){
                s = s.substring(1);
            }
        }

        int ans = 0;
        if(s.length() > 0) {
            String regex = "^([0-9]+)";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(s);
            if (m.find()) {
                String target = m.group(1);
                if(target.length() > 10){
                    if(isMinus){
                        return Integer.MIN_VALUE;
                    }else{
                        return Integer.MAX_VALUE;
                    }
                }
                Long result = Long.valueOf(target);
                if (isMinus && result > 2147483648l) {
                    ans = Integer.MIN_VALUE;
                } else if (!isMinus && result > Integer.MAX_VALUE) {
                    ans = Integer.MAX_VALUE;
                } else {
                    if(isMinus){
                        result = result * -1;
                    }
                    ans = Math.toIntExact(result);
                }
            }
        }
        return ans;
    }

    /**
     * 执行耗时:4 ms,击败了7.55% 的Java用户
     * 内存消耗:41.5 MB,击败了17.88% 的Java用户
     *
     * @param s
     * @return
     */
    public static int myAtoiProvider(String s){
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
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        char[] original = s.toCharArray();

        boolean isMinus = false;
        boolean isHead = true;
        StringBuffer ans = new StringBuffer();
        for(int i = 0 ; i < original.length; i ++){
            char cur = original[i];
            if(i == 0){
                if(cur == '-'){
                    isMinus = true;
                }else if(nums.contains(cur)){
                    if(cur != '0'){
                        ans.append(cur);
                        isHead = false;
                    }
                }else if(cur != '+'){
                    break;
                }
                continue;
            }

            if(!nums.contains(cur)){
                break;
            }

            if(cur == '0' && isHead){
                continue;
            }

            ans.append(cur);
            isHead = false;
        }

        if(ans.length() == 0){
            return 0;
        }else if(ans.length() > 10){
            if(isMinus){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }else if(ans.length() == 10){
            Integer num = Integer.valueOf(ans.substring(0, 9));
            if(num > 214748364){
                if(isMinus){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }else if (num == 214748364){
                Integer end = Integer.valueOf(ans.substring(9, 10));
                if(isMinus){
                    if(end > 8){
                        return Integer.MIN_VALUE;
                    }else{
                        return -2147483640 - end;
                    }
                }else{
                    if(end > 7){
                        return Integer.MAX_VALUE;
                    }else{
                        return 2147483640 + end;
                    }
                }
            }
        }

        Integer num = 0;
        if(isMinus){
            num = Integer.valueOf("-" + ans);
        }else{
            num = Integer.valueOf(ans.toString());
        }

        return num;
    }

    /**
     * 执行耗时:12 ms,击败了5.07% 的Java用户
     * 内存消耗:41.4 MB,击败了33.63% 的Java用户
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        s = s.trim();
        String regex = "^(([-+])?[\\d]+)[^\\d]?.*$";
        boolean isMinus = false;

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        if(m.matches()){
            String result = m.group(1);
            if(result.startsWith("-")){
                isMinus = true;
                result = result.substring(1);
            }else if(result.startsWith("+")){
                result = result.substring(1);
            }

            while(result.startsWith("0") && result.length() > 0){
                result = result.substring(1);
            }

            if(result.length() > 10){
                if(isMinus){
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }else if(result.length() == 10){
                int edge = Integer.valueOf(result.substring(0, 9));
                if( edge > 214748364){
                    if(isMinus){
                        return Integer.MIN_VALUE;
                    }
                    return Integer.MAX_VALUE;
                }else if(edge == 214748364){
                    int end = Integer.valueOf(result.substring(9, 10));
                    if(isMinus){
                        if(end > 8){
                            return Integer.MIN_VALUE;
                        }
                    }else{
                        if(end > 7){
                            return Integer.MAX_VALUE;
                        }
                    }
                }
            }else if(result.length() == 0){
                return 0;
            }

            if(isMinus){
                return Integer.valueOf("-" + result);
            }
            return Integer.valueOf(result);
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("0 = " + myAtoiLong("words and 987"));
        System.out.println("947 = " + myAtoiLong("   000947"));
        System.out.println("4193 = " + myAtoiLong("4193 with words"));
        System.out.println("42 = " + myAtoiLong("42"));
        System.out.println("12345678 = " + myAtoiLong(" 0000000000012345678"));
        System.out.println("-2147483648 = " + myAtoiLong("-2147483648"));
        System.out.println("2147483647 = " + myAtoiLong("2147483648"));
        System.out.println("1192820738 = " + myAtoiLong(" 1192820738r2"));
        System.out.println("0 = " + myAtoiLong(".1"));
        System.out.println("2147483647 = " + myAtoiLong("20000000000000000000"));
    }
}
