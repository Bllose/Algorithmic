package bllose.mathematical;

import java.lang.Math;

public class Calculations {

    /**
     * 将十进制小数转化为其他进制，保留十位小数
     */
    public String decimalToOther(Double input, int radix){
        StringBuffer sb = new StringBuffer();
        sb.append("0.");
        while(sb.length() < 12 && input > 0){
            input *= radix;
            int currectNum = (int) Math.floor(input);
            sb.append(currectNum);
            input -= currectNum;
        }
        return sb.toString();
    }
}
