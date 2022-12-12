package bllose.stringHandler;

/**
 * 小华是个很有对数字很敏感的小朋友，他觉得数字的不同排列方式有特殊美感。某天，小华突发奇想，如果数字多行排列，第一行1个数，第二行2个，第三行3个，
 * 即第n行有n个数字，并且奇数行正序排列，偶数行逆序排列，数字依次累加。这样排列的数字一定很有意思。聪明的你能编写代码帮助小华完成这个想法吗？
 * 规则总结如下：
 * a、每个数字占据4个位置，不足四位用‘*’补位，如1打印为1***。
 * b、数字之间相邻4空格。
 * c、数字的打印顺序按照正序逆序交替打印,奇数行正序，偶数行逆序。
 * d、最后一行数字顶格，第n-1行相对第n行缩进四个空格
 *
 * 输入 3
 * 输出
 *         1***
 *     3***    2***
 * 4***    5***    6***
 */
public class XiaoHuaLoveNumeral {

    public static void main(String[] args) {
        solution(6);
    }

    public static void solution(int height){
        int left = 1;
        int right = 1;
        for(int i = 1; i <= height; i ++){
            StringBuffer currectLine = new StringBuffer();
            int spaces = (height - i) * 4;
            while(spaces > 0){
                currectLine.append(" ");
                spaces --;
            }
            int le = left;
            int ri = right;
            if(i%2 != 0) {
                while(le <= ri){
                    currectLine.append(String.format("%-4d", le).replaceAll(" ", "*")).append("    ");
                    le ++;
                }
            }else {
                while(ri >= le){
                    currectLine.append(String.format("%-4d", ri).replaceAll(" ", "*")).append("    ");
                    ri --;
                }
            }
            left = right + 1;
            right += i + 1;
            System.out.println(currectLine);
        }
    }
}
