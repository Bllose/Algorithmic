package bllose.handler;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringToAnyThing {
    
    public List<String> toListString(String s){
        List<String> ans = Arrays.asList(s.split(" "));
        return ans;
    }

    /**
     * 匹配反向引用
     * 
     * @param string
     * @param num
     * @return
     */
    public static String num(String string){
        Matcher m = Pattern.compile("(a)\\1").matcher(string);
        if(m.find()){
            return m.group();
        }
        return "FAIL";
    }

    public static void main(String[] args) {
        System.out.println(num("affaa11faaac"));
    }
}
