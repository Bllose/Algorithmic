package bllose.arithmetic.arraybind;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static {
        System.out. println (System.getProperty ("user.dir"));
        // System.setIn(SwitchSubString.class.getResourceAsStream("D:\\workplace\\github\\bllose-algorithmic\\src\\main\\java\\bllose\\arithmetic\\switchsubstring\\Letters.txt"));
        try {
            System.setIn(new FileInputStream("src\\main\\java\\bllose\\arithmetic\\arraybind\\source.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第一行是每次读取的固定长度，0<长度<10
        第二行是整数数组的数目，0<数目<1000
        第3-n行是需要合并的数组，不同的数组用回车换行分隔，数组内部用逗号分隔，最大不超过100个元素。

     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int LEN = in.nextInt();
        int rows = in.nextInt();
        String[] rowArray = new String[rows];

        int totalLen = 0;
        for(int i = 0 ; i < rows ; i ++){
            String theRow = in.next();
            totalLen += theRow.length();
            rowArray[i] = theRow;
        }

        String regex = "(\\d+,){"+ LEN + "}";
        StringBuffer ans = new StringBuffer();
        while(ans.length() <= totalLen){
            for(int i = 0 ; i < rows; i ++){
                String curString = rowArray[i];
                if("".equals(curString)) continue;
                Matcher m = Pattern.compile(regex).matcher(curString);
                if(m.find()){
                    String matchedString = m.group(0);
                    ans.append(matchedString);
                    rowArray[i] = curString.substring(matchedString.length());
                }else{
                    ans.append(curString).append(",");
                    rowArray[i] = "";
                }
            }
        }

        System.out.println(ans.deleteCharAt(ans.length() - 1).toString());

    }
}
