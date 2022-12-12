package bllose.stringHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vowel {

    /**
     * solo从小就对英文字母非常感兴趣，
     * 尤其是元音字母(a,e,i,o,u,A,E,I,O,U)，
     * 他在写日记的时候都会把元音字母写成大写的，
     * 辅音字母则都写成小写，
     * 虽然别人看起来很别扭，
     * 但是solo却非常熟练。
     * 你试试把一个句子翻译成solo写日记的习惯吧。
     *
     * @param s
     * @return
     */
    public String solo(String s){
        s = s.toLowerCase();
        Matcher m = Pattern.compile("([aeiou])").matcher(s);
        StringBuffer sb = new StringBuffer();
        while (m.find()){
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public String soloOrigin(String s){
        char[] sChar = s.toLowerCase().toCharArray();
        for(int i = 0; i < sChar.length; i ++){
            switch(sChar[i]){
                case 'a': sChar[i] = 'A'; break;
                case 'e': sChar[i] = 'E'; break;
                case 'i': sChar[i] = 'I'; break;
                case 'o': sChar[i] = 'O'; break;
                case 'u': sChar[i] = 'U'; break;
            }
        }
        return String.valueOf(sChar);
    }
}
