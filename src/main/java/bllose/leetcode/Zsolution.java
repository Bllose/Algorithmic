package bllose.leetcode;

public class Zsolution {

    /**
     * 			执行耗时:3 ms,击败了86.61% 的Java用户
     * 			内存消耗:41.6 MB,击败了75.87% 的Java用户
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }else {
            StringBuffer sb = new StringBuffer(); 
            char[] original = s.toCharArray();
            int add = 2 * (numRows - 1);
            for(int row = 0; row < numRows; row ++){
                for(int cur = row; cur < original.length; cur += add){
                    sb.append(original[cur]);
                    if(row == 0 || row == numRows - 1){
                        continue;
                    }else if(cur + add - 2 * row < original.length){
                        sb.append(original[cur + add - 2 * row]);
                    }
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("PAHNAPLSIIGYIR = " + convert("PAYPALISHIRING", 3));
        System.out.println("PINALSIGYAHRPI = " + convert("PAYPALISHIRING", 4));
    }
}
