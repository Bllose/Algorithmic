package bllose.backtracking;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    
    public String bruteForce(String target){
        String result = "";

        if(null == target || target.trim().length() == 0) return result;

        char[] tarChar = target.toCharArray();
        for(int i =0; i < tarChar.length; i ++){
            for(int j = tarChar.length -1; j >= i ; j --){
                int curHead = i;
                int curTail= j;
                for(; curTail > curHead;){
                    if(tarChar[curHead] == tarChar[curTail]){
                        curHead ++;
                        curTail --;
                    }else{
                        break;
                    }
                }
                if(curHead >= curTail){
                    if((j == i && result.length() == 0)
                        || j-i >= result.length()){
                        result = target.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 409. 最长回文
     * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
     *
     * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     * @param s
     * @return
     */
    public String dynamicProgrammingRepeat(String s){
        if(s==null || s.length()==0) return "";
        if(s.length() == 1) return s;
        final int LEN = s.length();
        Boolean[][] recorder = new Boolean[LEN][LEN];
        for(int i = 0; i < LEN; i ++){
            recorder[i][i] = true;
        }

        int begin = 0;
        int lenght = 1;
        char[] sChar = s.toCharArray();
        for(int len = 2; len <= LEN; len ++) {
            for(int left = 0; left <= LEN-len; left ++){ // left 代表当前比对的字母； right 表示与当前字母比较的距离
                int right = left + len - 1;
                if(sChar[left] != sChar[right]){
                    recorder[left][right] = false;
                }else{
                    if(len<3){
                        recorder[left][right] = true;
                    }else{
                        recorder[left][right] = recorder[left+1][right -1]; // 更短的距离， 说明是上一轮的比较结果。
                    }

                    if(recorder[left][right] && len > lenght){
                        begin = left;
                        lenght = len;
                    }
                }
            }
        }
        
        return s.substring(begin, begin + lenght);
    }


    public String dynamicProgramming(String s){
        if(null == s || s.length() == 0) return "";
        int len = s.length();
        if(len == 1) return s;

        Boolean[][] recorder = new Boolean[len][len];

        for(int i = 0 ; i < len; i ++){
            recorder[i][i] = true;
        }
        
        int begin = 0;
        int length = 1;
        
        char[] sChar = s.toCharArray();
        for(int curLen = 2; curLen <= len; curLen ++){
            for(int left = 0; left < len; left ++){
                int right = left + curLen - 1;
                if(right >= len) break;
                if(sChar[left] != sChar[right]){
                    recorder[left][right] = false;
                }else{
                    if(curLen <= 3){
                        recorder[left][right] = true;
                    }else{
                        recorder[left][right] = recorder[left+1][right-1];
                    }
                }
                if(recorder[left][right] && curLen>length){
                    begin = left;
                    length = curLen;
                }
            }
        }
        
        return s.substring(begin, begin + length);
    }

    public String centralExtension(String s){
        if(s==null || s.length() == 0) return "";
        if(s.length()==1) return s;

        char[] sChar = s.toCharArray();
        int begin = -1;
        int end = -2; // 初始化时， 极端场景下应该确保 end - begin + 1 应该为0
        for(int center = 1; center < sChar.length; center ++){
            if(sChar[center - 1] == sChar[center]){
                int left = center - 1;
                int right = center;
                int radius = traversal(sChar, left, right);
                if(end - begin + 1 < radius * 2 || end - begin <= 0){ // end - begin 为数组下标间隔，比实际长度短 1
                    begin = left - radius + 1; // 由于拓展时，首先从相同的两个字母开始，所以第一个半径时不需要加入计算的
                    end = right + radius - 1;
                }
            }else{
                int left = center - 1;
                int right = center + 1;
                int radius = traversal(sChar, left, right);
                if(end - begin + 1 < radius * 2 + 1){
                    begin = center - radius;
                    end = center + radius;
                }
            }
        }

        return s.substring(begin, end + 1); // begin, end为数组下标， 在实际长度中，尾部应该加一
    }

    private int traversal(char[] sChar, int left, int right){
        if(right >= sChar.length || sChar[left] != sChar[right]) return 0;
        if(left - 1 < 0 || right + 1 > sChar.length) return 1;
        return 1 + traversal(sChar, left - 1, right + 1);
    }


    /**
     * 8 ms	39.9 MB
     * 
     * @param s
     * @return
     */
    public int longestPalindromeInt(String s){
        if(null == s || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        char[] sChar = s.toCharArray();
        Map<Character, Integer> recorder = new HashMap<>();

        for(char cur: sChar){
            if(recorder.containsKey(cur)){
                recorder.put(cur, recorder.get(cur) + 1);
            }else{
                recorder.put(cur, 1);
            }
        }

        int counter = 0;
        boolean hasCenter = false;
        for(Integer num: recorder.values()){
            if(num > 2) counter += (num / 2) * 2;
            if(num == 2) counter += 2;
            if(num % 2 == 1) hasCenter = true;
        }

        if(hasCenter) counter ++;

        return counter;
    }

    /**
     * 5 ms	41 MB
     * @param s
     * @return
     */
    public int longestPalindromeInt2(String s){
        if(null == s || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        char[] sChar = s.toCharArray();
        Map<Character, Integer> recorder = new HashMap<>();

        int counter = 0;
        for(char cur: sChar){
            if(recorder.containsKey(cur)){
                recorder.remove(cur);
                counter += 2;
            }else{
                recorder.put(cur, 1);
            }
        }

        if(!recorder.isEmpty()) counter ++;

        return counter;
    }

    /**
     * 1 ms	39.7 MB
     * 
     * @param s
     * @return
     */
    public int longestPalindromeInt3(String s){
        int ans = 0;
        int[] counter = new int[128];
        char[] sChar = s.toCharArray();

        for(char cur: sChar){
            counter[cur] ++;
        }

        for(int cur: counter){
            ans += cur/2 *2;
            if(cur%2==1 && ans%2==0){
                ans ++;
            }
        }

        return ans;
    }




    public static void main(String[] args) {
        String target = "Bllose";
        System.out.println(target.length());
        System.out.println(target.substring(0, 6));
        char[] tarChar = target.toCharArray();
        System.out.println(tarChar[5]);
        Boolean[] a = new Boolean[]{null, true};
        if(a[0]){
            System.out.println("1");
        }
    }
}
