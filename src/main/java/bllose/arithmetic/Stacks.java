package bllose.arithmetic;

import java.util.Arrays;
import java.util.Stack;

public class Stacks {

    /**
     * (1+(2+3)*(3+(8+0))+1-2)这是一个简单的数学表达式，
     * 今天不是计算它的值，而是比较它的括号匹配是否正确。
     * 前面这个式子可以简化为(()(()))这样的括号我们认为它是匹配正确的，而((())这样的我们就说他是错误的。
     * 注意括号里面的表达式可能是错的，也可能有多个空格，对于这些我们是不用去管的，我们只关心括号是否使用正确。
     *
     * @param target
     * @return
     */
    public int parentheses(String target){
        int result = 0;
        Stack<Character> stk = new Stack<>();

        char[] targetChar = target.toCharArray();
        for(char cur: targetChar){
            if(cur == '('){
                stk.push('(');
            }else if( cur == ')'){
                if(stk.isEmpty()) return -1;
                stk.pop();
                result ++;
            }
        }

        if(!stk.isEmpty()) return -1;

        return result;
    }

    /**
     * LeetCode 1249. 移除无效的括号
     *
     * 给你一个由 '('、')' 和小写字母组成的字符串 s。
     *
     * 你需要从字符串中删除最少数目的 '(' 或者 ')'（可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
     *
     * 请返回任意一个合法字符串。
     *
     * 有效「括号字符串」应当符合以下 任意一条 要求：
     *
     * 空字符串或只包含小写字母的字符串
     * 可以被写作 AB（A 连接 B）的字符串，其中A 和B 都是有效「括号字符串」
     * 可以被写作(A)的字符串，其中A是一个有效的「括号字符串」
     *
     * 22:20	info
     * 			解答失败:
     * 			测试用例:"a)b(c)d"
     * 			测试结果:"a"
     * 			期望结果:"ab(c)d"
     * 			stdout:
     * 22:26	info
     * 			运行失败:
     * 			java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
     * 			at line 23, Solution.minRemoveToMakeValid
     * 			at line 54, __DriverSolution__.__helper__
     * 			at line 84, __Driver__.main
     * 			测试用例:"))(("
     * 			stdout:
     * 	22:31	info
     * 			解答成功:
     * 			执行耗时:27 ms,击败了55.47% 的Java用户
     * 			内存消耗:42.5 MB,击败了11.59% 的Java用户
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> recorder = new Stack<>();
        Stack<Integer> remover = new Stack<>();

        char[] sChar = s.toCharArray();
        for(int i = 0 ; i < sChar.length; i ++){
            if(sChar[i] == '('){
                recorder.push(i);
            }else if(sChar[i] == ')'){
                if(recorder.isEmpty()){
                    remover.push(i);
                }else{
                    recorder.pop();
                }
            }
        }

        if(!remover.isEmpty() || !recorder.isEmpty()){
            int[] removeIndex = new int[remover.size() + recorder.size()];
            int i = 0;
            while(!remover.isEmpty()){
                removeIndex[i] = remover.pop();
                i ++;
            }
            while(!recorder.isEmpty()){
                removeIndex[i] = recorder.pop();
                i ++;
            }
            Arrays.sort(removeIndex);

            int left = 0;
            StringBuffer sb = new StringBuffer();
            for(i = 0; i < removeIndex.length ; i ++){
                int right = removeIndex[i];
                sb.append(new String(sChar, left, right - left));
                left = right + 1;
            }
            sb.append(sChar, left, sChar.length - left);

            return sb.toString();
        }

        return s;
    }

    /**
     * 加入是最后一个字符需要被剔除到
     * 那么对于array比较的数值index = 7
     * 获取前面7个数字 subString(0,7)
     * 末尾应该使用 subString(8,8)
     * 第一个 8 为 array的index 7 再加 1 : 7+1 = 8
     * 第二个 8 为 字符长度 s.length()
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "12345678";
        System.out.println("length ->" + s.length());
        System.out.println(s.substring(0,8));
        System.out.println(s.substring(0,7) + s.substring(8,8));

        char[] sC = {'1', '2', '3', '4', '5', '6', '7', '8'};
        System.out.println(sC[7]);

        System.out.println(new String(sC, 0, 2-0));
        System.out.println(new String(sC, 3, 5-3));
    }
}
