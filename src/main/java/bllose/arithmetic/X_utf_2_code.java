package bllose.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * 1字节 0xxxxxxx ?
 * 2字节 10xxxxxx 10xxxxxx
 * 6字节 1111110x 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx
 *
 * X-UTF : E58D8E
 * HEX:    11100101 10001101 10001110
 * DECIMAL: 21326
 */
public class X_utf_2_code {
    static Map<Character, Integer> hexMap = new HashMap(){{
        put('0', 0);
        put('1', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('A', 10);
        put('B', 11);
        put('C', 12);
        put('D', 13);
        put('E', 14);
        put('F', 15);
    }};
    static String[] binary = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
            "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
    public static int encodingVerify(String strInput){
        char[] charInput = strInput.toCharArray();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < charInput.length; i ++){
            sb.append(binary[hexMap.get(charInput[i])]);
        }

        int len = 0;
        for(int i = 0 ; i < 7 ; i ++) {
            if(sb.charAt(i) == '1'){
                len ++;
            }else{
                break;
            }
        }
        // 当长度为一时， 以0开头，也就意味着 len 为0 ?
        // 这时候应该适当处理
        if(len * 8 != sb.length()) return -1;

        StringBuffer xUtfCode = new StringBuffer();
        for(int i = 0 ; i < sb.length(); i += 8){
            String curSb = sb.substring(i, i + 8);
            if(i == 0){
                xUtfCode.append(curSb.substring(len+1)); // 1110 4
                continue;
            }else{
                if(!curSb.startsWith("10")) return -1;
                xUtfCode.append(curSb.substring(2));    // 10 2
            }
        }

        int result = 0;
        int pow = xUtfCode.length() - 1;
        for( int i = 0; i < xUtfCode.length() ; i ++){
            if(xUtfCode.charAt(i) == '1'){
                result += Math.pow(2, pow - i);
            }
        }

        return result;
    }
}
