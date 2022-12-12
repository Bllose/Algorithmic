package bllose.helpers;

public class ArrayHelper {

    static String[] PRE_FORMAT = {"%d", "%1d", "%2d", "%3d", "%4d", "%5d", "%6d", "%7d"};
    static String[] SUF_FORMAT = {"%d", "%-1d", "%-2d", "%-3d", "%-4d", "%-5d", "%-6d", "%-7d"};

    /**
     * 默认二位数组字符串化
     * 
     * @param array
     * @return
     */
    public static String showTwoDimensionalArray(Integer[][] array){
        return showTwoDimensionalArray(array, false, true, true, 4);
    }
    
    /**
     * 
     * @param array 
     * @param console 是否直接打印
     * @param upsideDown true - 首行在底部; false - 与数据结构保持一致
     * @param format true - 后面补位; false - 前面补位
     * @param formatType 补位数量 0 - 无补位; 2 - 如果数字为一位则补一位; 4 - 如果数字为二位则补两位; 默认为4
     * @return 组装
     */
    public static String showTwoDimensionalArray(Integer[][] array, boolean console, boolean upsideDown, 
                                                 boolean format, Integer formatType){
        String[] formats = SUF_FORMAT;
        if(format) formats = PRE_FORMAT;
        int formatNum = formatType == null? 4: formatType;

        String edge = " ";
        for(int i = 1 ; i < formatType ; i ++){
            edge += " ";
        }

        int heigth = array.length;
        int weigth = array[0].length;
        StringBuffer result = new StringBuffer();
        if(upsideDown){
            for(int h = heigth - 1; h > 0 ; h --){
                for(int w = 0; w < weigth; w ++){
                    result.append(String.format(formats[formatNum], array[h][w])).append(edge);
                }
                result.append("\r\n");
            }
        } else{
            for(int h = 0; h < heigth ; h ++){
                for(int w = 0; w < weigth; w ++){
                    result.append(String.format(formats[formatNum], array[h][w])).append(edge);
                }
                result.append("\r\n");
            }
        }

        if(console){
            System.out.println(result);
        }

        return result.toString();
    }
}
