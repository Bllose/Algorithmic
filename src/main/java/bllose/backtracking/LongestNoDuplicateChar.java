package bllose.backtracking;

public class LongestNoDuplicateChar {

    int longestLengthSubString(String s){
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int longestLength = 0;

        char[] sChar = s.toCharArray();
        int left = 0;
        int right = 1;

        while (right < sChar.length){
            int i = left;
            for(; right < sChar.length && i < right; i ++){
                if(sChar[i] == sChar[right]){
                    left = i;
                    break;
                }
            }
            if(i != right){
                /* 底层长度 right - left; 会比上层长度短 1;
                 * 比如: [0, 1] : right - left = 1 - 0 = 1; 但实际长度 01 -> 为 2
                 * 此处由于 right 的增量，导致原字符串的非重复属性被打破
                 * 所以不重复子串长度不包括 right
                 * 故，使用底层长度 right - left， 刚好就是上层非重复子串长度
                 */
                if(right - left > longestLength) longestLength = right - left;
                left = i + 1;
            }
            right ++;
        }

        return longestLength;
    }
}
